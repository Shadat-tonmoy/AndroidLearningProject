package com.shadattonmoy.androidJetPackDemo.helpers;

import android.content.Context;

import com.shadattonmoy.androidJetPackDemo.R;
import com.shadattonmoy.androidJetPackDemo.constants.enums.WeatherInfoType;
import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherInfo;

public class StringHelper
{
    public static String capitalizeString(String text)
    {
        return text.toUpperCase();
    }

    public static String getWeatherInfoTitle(Context context, WeatherInfoType weatherInfoType)
    {
        int stringID = R.string.temperature;
        switch (weatherInfoType)
        {
            case HUMIDITY:
                stringID = R.string.humidity;
                break;
            case PRESSURE:
                stringID = R.string.pressure;
                break;
            case MIN_TEMPERATURE:
                stringID = R.string.min_temperature;
                break;
            case MAX_TEMPERATURE:
                stringID = R.string.max_temperature;
                break;
        }
        return context.getString(stringID);
    }

    public static String getWeatherInfoValue(Context context, WeatherInfoType weatherInfoType, WeatherInfo weatherInfo)
    {
        switch (weatherInfoType)
        {
            case TEMPERATURE:
                return context.getString(R.string.temperature_value,weatherInfo.getTemperature());
            case HUMIDITY:
                return context.getString(R.string.humidity_value,weatherInfo.getHumidity());
            case PRESSURE:
                return context.getString(R.string.pressure_value,weatherInfo.getPressure());
            case MIN_TEMPERATURE:
                return context.getString(R.string.min_temperature_value,weatherInfo.getMinimumTemperature());
            case MAX_TEMPERATURE:
                return context.getString(R.string.max_temperature_value,weatherInfo.getMaximumTemperature());
        }
        return context.getString(R.string.temperature_value,weatherInfo.getTemperature());
    }
}
