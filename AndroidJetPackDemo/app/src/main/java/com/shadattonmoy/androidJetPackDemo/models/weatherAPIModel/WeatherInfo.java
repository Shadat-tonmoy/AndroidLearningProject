package com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel;

import com.google.gson.annotations.SerializedName;

public class WeatherInfo
{
    @SerializedName("temp")
    private double temperature;
    private double pressure;
    private double humidity;
    @SerializedName("temp_min")
    private double minimumTemperature;
    @SerializedName("temp_max")
    private double maximumTemperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(double minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(double maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", minimumTemperature=" + minimumTemperature +
                ", maximumTemperature=" + maximumTemperature +
                '}';
    }
}
