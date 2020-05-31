package com.mlvolt.protienboothuser.Model;

public class GymModel {
    public String timing;
    public String price;
    public String about;
    public String rating;

    public GymModel() {
    }



    public GymModel(String timing, String price, String about, String rating) {
        this.timing = timing;
        this.price = price;
        this.about = about;
        this.rating = rating;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
