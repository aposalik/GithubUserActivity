package org.example;
import com.google.gson.annotations.SerializedName;

import java.util.List;


// CLASS for REPO
class Repo {
    @SerializedName("name")

    String name;
    Repo() {};

    public String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }
}

// CLASS FOR PAYLOAD
class Payload{

    @SerializedName("size")
    private Integer size;
    @SerializedName("action")
    String action;
    @SerializedName("ref_type")
    String refType;
    @SerializedName("commits")
    private List<Object> commits;  // ← ADD THIS! Use Object since we don't need commit details


    // Constractor
    Payload(){};

    // Getters
    public String getAction() {
        return action;
    }
    public Integer getSize(){
        return this.size;
    }
    public String getRefType(){
        return this.refType;
    }
    public List<Object> getCommits(){
        return this.commits;
    }

    public Integer getCommitsSize(){
        if(commits != null){
            return commits.size();
        }
        return size;
    }

    // Setters
    public void setSize(Integer size){
        this.size = size;
    }

    public void setAction(String action){
        this.action = action;
    }

    public void setRefType(String refType){
        this.refType = refType;
    }
    public void setCommits(List<Object> commits){
        this.commits = commits;
    }


}





// Class for EVENT
public class Event {
    @SerializedName("type")
    private String type;
    @SerializedName("repo")

    private Repo repo;
    @SerializedName("payload")

    private Payload payload;
    @SerializedName("created_at")

    private String createdAt;

    Event(){};
    Event(String type, Repo repo, Payload payload, String createdAt) {
        this.type = type;
        this.repo = repo;
        this.payload = payload;
        this.createdAt = createdAt;
    }

    //add getters
    public String getType() {
        return type;
    }
    public Repo getRepo() {
        return repo;
    }
    public Payload getPayload() {
        return payload;
    }
    public String getCreatedAt() {
        return createdAt;
    }



    // Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setRepo(Repo repo) {
        this.repo = repo;
    }
    public void setPayload(Payload payload) {
        this.payload = payload;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
