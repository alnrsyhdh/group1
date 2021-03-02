package com.example.group2;

public class FeedbackDatabase {
    private String fullname, username, feedback;

    public FeedbackDatabase(){

    }
    
    public FeedbackDatabase(String fullname, String username, String feedback){
        this.fullname=fullname;
        this.username=username;
        this.feedback=feedback;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}


