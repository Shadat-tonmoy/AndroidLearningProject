package com.stcodesapp.quotes_einstein.common;

import android.util.Log;

import com.stcodesapp.quotes_einstein.BuildConfig;

public class Logger
{
    private static boolean showLog = BuildConfig.DEBUG;

    public static void showLog(String tag, String message)
    {
        if(showLog)
        {
            Log.e(tag,message);
        }
    }

}
