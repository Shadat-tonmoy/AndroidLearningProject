package com.stcodesapp.bmicalculator.dataSource;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class RandomNumberGenerator extends ViewModel
{
    private static final String TAG = "RandomNumberGenerator";

    private MutableLiveData<String> randomNumberString;

    public LiveData<String> getRandomNumber()
    {
        if(randomNumberString==null)
        {
            randomNumberString = new MutableLiveData<>();
            createRandomNumber();
        }
        return randomNumberString;

    }

    public void createRandomNumber()
    {
        Log.e(TAG, "createRandomNumber: CratingRandomNumber...");
        Random random = new Random();
        randomNumberString.setValue("Random Number is : "+random.nextInt(50));
    }
}
