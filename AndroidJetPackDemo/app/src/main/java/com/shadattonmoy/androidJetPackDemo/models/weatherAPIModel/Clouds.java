package com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel;

public class Clouds
{
    private double all;

    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
