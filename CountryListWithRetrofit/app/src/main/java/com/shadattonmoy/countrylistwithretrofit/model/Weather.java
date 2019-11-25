package com.shadattonmoy.countrylistwithretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Weather
{
    private long id;
    @SerializedName("main")
    private String title;
    private String description;
    private String icon;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
