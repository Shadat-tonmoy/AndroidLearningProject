package com.stcodesapp.bmicalculator.dataSource;

import java.util.Random;

public class RandomNumberGenerator
{
    private static final String TAG = "RandomNumberGenerator";

    private String randomNumberString;

    public String getRandomNumber()
    {
        if(randomNumberString==null)
            createRandomNumber();
        return randomNumberString;

    }

    public void createRandomNumber()
    {
        Random random = new Random();
        randomNumberString = "Random Number is : "+random.nextInt(50);
    }
}
