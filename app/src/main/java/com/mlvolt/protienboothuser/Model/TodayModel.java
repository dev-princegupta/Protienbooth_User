package com.mlvolt.protienboothuser.Model;

public class TodayModel {
    String weight;
    String workout;
    String preworkout;
    String postworkout;
    String your;

    public TodayModel() {
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

    public String getYour() {
        return your;
    }

    public void setYour(String your) {
        this.your = your;
    }

    public TodayModel(String weight, String workout, String preworkout, String postworkout, String your) {
        this.weight = weight;
        this.workout = workout;
        this.preworkout = preworkout;
        this.postworkout = postworkout;
        this.your = your;
    }
}
