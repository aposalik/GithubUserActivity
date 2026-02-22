package org.example;

public class ActivityFormatter {

    public String format (Event event) {

        String type = event.getType();
        String repoName = event.getRepo().getName();

        switch (type) {
            case "WatchEvent":
                return "Starred " + repoName;

                case "PushEvent":
                    Integer commitCount = event.getPayload().getCommitsSize();
                    if(commitCount != null  && commitCount > 0) {
                        return "Pushed commits to " + repoName;
                    }
                    return null;

                    case "IssuesEvent":
                        // Bonus: Can you handle this?
                        // Hint: payload has "action" field (opened/closed)
                        String action = event.getPayload().getAction();

                        if (action != null) {
                            return action +" an issue in " + repoName;  // How to format?
                        }
                        return null;

            case "CreateEvent":
                String refType =  event.getPayload().getRefType();
                if (refType != null) {
                    if (refType.equals("repository")) {
                        return "Created a new repository " + repoName;
                    } else if (refType.equals("branch")) {
                        return "Created a new branch in " + repoName;
                    } else if (refType.equals("tag")) {
                        return "Created a new tag in " + repoName;
                    }
                }
                return "Created something in " + repoName;

                case "ForkEvent":
                    return "Forked " + repoName;

            default:
                return null;
        }
    }

}
