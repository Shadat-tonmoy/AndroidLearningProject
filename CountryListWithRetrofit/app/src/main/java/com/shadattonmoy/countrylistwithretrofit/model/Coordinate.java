package com.shadattonmoy.countrylistwithretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Coordinate
{
    @SerializedName("lon")
    private double longitude;
    @SerializedName("lat")
    private double latitude;



    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
}
