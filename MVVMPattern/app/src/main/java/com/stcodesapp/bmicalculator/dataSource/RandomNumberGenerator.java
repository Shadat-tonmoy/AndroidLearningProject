package com.stcodesapp.bmicalculator.dataSource;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class RandomNumberGenerator extends ViewModel
{
    private static final String TAG = "RandomNumberGenerator";

    private String randomNumberString;

    public String getRandomNumber()
    {
        if(randomNumberString==null)
            createRandomNumber();
        return randomNumberString;

    }

    private void createRandomNumber()
    {
        Log.e(TAG, "createRandomNumber: CratingRandomNumber...");
        Random random = new Random();
        randomNumberString = "Random Number is : "+random.nextInt(50);
    }
}
