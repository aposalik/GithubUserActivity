package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        if(args.length == 0){
            System.out.println("Usage: java Main <github-username>");
            return;
        }
        String username = args[0];

        // Step 2: Create instances of your classes
        GitHubApiClient gitHubApiClient = new GitHubApiClient();
        JsonParser jsonParser = new JsonParser();
        ActivityFormatter formatter = new ActivityFormatter();

        // Step 3: Fetch JSON
        try {
            String json = gitHubApiClient.fetchUserEvents(username);
            
            // DEBUG: Print first event's raw JSON
            System.out.println("=== FIRST EVENT RAW JSON ===");
            int firstEventEnd = json.indexOf("},") + 1;
            if (firstEventEnd > 0) {
                System.out.println(json.substring(1, Math.min(firstEventEnd + 500, json.length())));
            }
            System.out.println("=== END RAW JSON ===");
            System.out.println();
            
            List<Event> events = jsonParser.parseJson(json);

            if(events.isEmpty()){
                System.out.println("No recent activity found for user: " + username);
                return;
            }

            for(Event event : events){
                // Debug: Print detailed event info
                System.out.println("=== DEBUG ===");
                System.out.println("Type: " + event.getType());
                System.out.println("Repo: " + event.getRepo().getName());
                System.out.println("=============");

                String message = formatter.format(event);
                if(message != null){
                    System.out.println("- " + message);
                }
                System.out.println();  // Empty line for readability
            }

        }catch (IOException e) {
            System.err.println("Error: Unable to fetch data from GitHub.");
            System.err.println("Reason: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Error: Request was interrupted.");
            System.err.println("Reason: " + e.getMessage());
        }
    }
}