package org.example;



// CLASS for REPO
class Repo {
    String name;
}



// CLASS FOR PAYLOAD
class Payload{
    private Integer size;
    String url;
    String action;
    Commit commits;

    // Constractor
    Payload(){};

    // Getters
    String getAction() {
        return action;
    }
    int getSize(){
        return this.size;
    }

    // Setters
    int setSize(Integer size){
        this.size = size;
    };
    String setAction(String action){
        this.action = action;
    }


}





// Class for EVENT
public class Event {
    String type;
    Repo repo;
    Payload payload;
    String time;

    Event(String type, Repo repo, Payload payload, String time) {
        this.type = type;
        this.repo = repo;
        this.payload = payload;
        this.time = time;
    }
}

class Commit {
    String sha;
    String message;
    Commit(String sha, String message) {
        this.sha = sha;
        this.message = message;
    }
}
