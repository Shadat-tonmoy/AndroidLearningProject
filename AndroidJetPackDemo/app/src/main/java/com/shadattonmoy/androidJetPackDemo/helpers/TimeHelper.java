package com.shadattonmoy.androidJetPackDemo.helpers;

import com.shadattonmoy.androidJetPackDemo.R;

import java.util.Calendar;

public class TimeHelper
{
    public static int getBackgroundImageId()
    {
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12)
        {
            //morning
            return R.drawable.day;
        }
        else if(timeOfDay >= 12 && timeOfDay < 16)
        {
            //day
            return R.drawable.day;
        }
        else if(timeOfDay >= 16 && timeOfDay < 21)
        {
            //evening
            return R.drawable.night;
        }
        else if(timeOfDay >= 21 && timeOfDay < 24)
        {
            //night
            return R.drawable.night;
        }
        return -1;
    }
}
