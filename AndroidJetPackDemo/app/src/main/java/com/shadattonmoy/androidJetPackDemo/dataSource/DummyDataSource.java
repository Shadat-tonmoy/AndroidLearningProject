package com.shadattonmoy.androidJetPackDemo.dataSource;

import com.shadattonmoy.androidJetPackDemo.models.Person;
import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherData;
import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherInfo;

import java.util.Random;

public class DummyDataSource
{
    public static Person getDummyPerson()
    {
        return new Person("Shadat Tonmoy","Software Engineer");
    }

    public static WeatherData getDummyWeatherData()
    {
        WeatherData weatherData = new WeatherData();
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setTemperature(32.0);
        weatherData.setWeatherInfo(weatherInfo);
        return weatherData;
    }

    public static Person getUpdatedPerson()
    {

        Random random = new Random();
        int personID = random.nextInt(50);
        int designationID = random.nextInt(50);
        return new Person("Updated Person " + personID + "  : Shadat Tonmoy","Updated Designation "+ designationID +": Software Engineer");
    }
}
