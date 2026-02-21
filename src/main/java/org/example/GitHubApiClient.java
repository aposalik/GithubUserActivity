package org.example;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class GitHubApiClient {

    private static final String BASE_URL = "https://api.github.com/users/";  // What goes here?

    // Constractor
    public GitHubApiClient() {};
    public String fetchUserEvents (String username) throws IOException, InterruptedException {
        // TODO: Build the complete URL
        String url = BASE_URL + username +"/events";  // How to build it?

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return  response.body();
    }


}