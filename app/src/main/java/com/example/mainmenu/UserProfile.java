package com.example.mainmenu;

public class UserProfile {
    //Attributes
    private String username;
    private String password;
    private int hiddenRating;
    //Constructors
    public UserProfile(String username, String password){
        this.password = password;
        this.username = username;
        hiddenRating = 0;
    }
    //Methods
    public void increaseRating(int ratingChange){
        this.hiddenRating += ratingChange;
    }
    public void decreaseRating(int ratingChange){
        if(this.hiddenRating - ratingChange <= 0){
            this.hiddenRating = 0;
        }else this.hiddenRating -= ratingChange;
    }
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
}
