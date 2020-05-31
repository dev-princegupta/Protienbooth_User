package com.mlvolt.protienboothuser.Model;

public class TodayModel {
    public String userName;
    public String weight;
    public String workout;
    public String preworkout;
    public String postworkout;
    public String yourProteinQuantity;

    public TodayModel() {
    }

    public TodayModel(String userName, String weight, String workout, String preworkout, String postworkout, String yourProteinQuantity) {
        this.userName = userName;
        this.weight = weight;
        this.workout = workout;
        this.preworkout = preworkout;
        this.postworkout = postworkout;
        this.yourProteinQuantity = yourProteinQuantity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public String getPreworkout() {
        return preworkout;
    }

    public void setPreworkout(String preworkout) {
        this.preworkout = preworkout;
    }

    public String getPostworkout() {
        return postworkout;
    }

    public void setPostworkout(String postworkout) {
        this.postworkout = postworkout;
    }

    public String getYourProteinQuantity() {
        return yourProteinQuantity;
    }

    public void setYourProteinQuantity(String yourProteinQuantity) {
        this.yourProteinQuantity = yourProteinQuantity;
    }
}
