package com.shadattonmoy.androidJetPackDemo.helpers;

import java.util.Random;

public class NetworkHelper
{
    public static boolean isInternetAvailable()
    {
        //fake implementation
        Random random = new Random();
        int randomInt = random.nextInt();
        return randomInt%2==0;
    }
}
