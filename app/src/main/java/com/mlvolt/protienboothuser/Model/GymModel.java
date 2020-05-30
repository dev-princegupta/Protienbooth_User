package com.mlvolt.protienboothuser.Model;

public class GymModel {
    public String gym_name;
    public String contact_no;
    public String price;

    public GymModel() {
    }

    public GymModel(String gym_name, String contact_no, String price) {
        this.gym_name = gym_name;
        this.contact_no = contact_no;
        this.price = price;
    }

    public String getGym_name() {
        return gym_name;
    }

    public void setGym_name(String gym_name) {
        this.gym_name = gym_name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
