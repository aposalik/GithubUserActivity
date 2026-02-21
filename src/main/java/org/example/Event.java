package org.example;
import com.google.gson.annotations.SerializedName;




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
