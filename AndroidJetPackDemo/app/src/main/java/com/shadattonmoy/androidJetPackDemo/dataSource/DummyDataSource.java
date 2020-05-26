package com.shadattonmoy.androidJetPackDemo.dataSource;

import com.shadattonmoy.androidJetPackDemo.models.Person;

public class DummyDataSource
{
    public static Person getDummyPerson()
    {
        return new Person("Shadat Tonmoy","Software Engineer");
    }
}
