package com.shadattonmoy.countrylistwithretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Coordinate
{
    @SerializedName("lon")
    private long longitude;
    @SerializedName("lat")
    private long latitude;

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
}
