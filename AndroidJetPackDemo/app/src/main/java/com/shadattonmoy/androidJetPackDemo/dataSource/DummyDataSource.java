package com.shadattonmoy.androidJetPackDemo.dataSource;

import com.shadattonmoy.androidJetPackDemo.models.Person;

import java.util.Random;

public class DummyDataSource
{
    public static Person getDummyPerson()
    {
        return new Person("Shadat Tonmoy","Software Engineer");
    }

    public static Person getUpdatedPerson()
    {

        Random random = new Random();
        int personID = random.nextInt(50);
        int designationID = random.nextInt(50);
        return new Person("Updated Person " + personID + "  : Shadat Tonmoy","Updated Designation "+ designationID +": Software Engineer");
    }
}
