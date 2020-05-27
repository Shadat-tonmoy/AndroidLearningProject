package com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherData
{

    @SerializedName("coord")
    private Coordinate coordinate;
    private List<Weather> weather;
    private String base;
    @SerializedName("main")
    private WeatherInfo weatherInfo;
    private long visibility;
    private Wind wind;
    private Clouds clouds;
    @SerializedName("dt")
    private long dataTime;
    @SerializedName("sys")
    private SystemInfo systemInfo;
    private long id;
    @SerializedName("name")
    private String cityName;
    @SerializedName("cod")
    private long currentOrientationData;


    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public long getDataTime() {
        return dataTime;
    }

    public void setDataTime(long dataTime) {
        this.dataTime = dataTime;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo systemInfo) {
        this.systemInfo = systemInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getCurrentOrientationData() {
        return currentOrientationData;
    }

    public void setCurrentOrientationData(long currentOrientationData) {
        this.currentOrientationData = currentOrientationData;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "coordinate=" + coordinate +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", weatherInfo=" + weatherInfo +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dataTime=" + dataTime +
                ", systemInfo=" + systemInfo +
                ", id=" + id +
                ", cityName='" + cityName + '\'' +
                ", currentOrientationData=" + currentOrientationData +
                '}';
    }
}
