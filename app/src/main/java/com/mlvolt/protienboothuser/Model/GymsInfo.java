package com.mlvolt.protienboothuser.Model;

public class GymsInfo {
    String name;
    double latitude;
    double longitude;

    public GymsInfo() {
    }

    public GymsInfo(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
