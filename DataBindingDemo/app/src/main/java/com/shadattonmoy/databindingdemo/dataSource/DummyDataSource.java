package com.shadattonmoy.databindingdemo.dataSource;

import com.shadattonmoy.databindingdemo.models.Person;

public class DummyDataSource
{
    public static Person getDummyPerson()
    {
        return new Person("Shadat Tonmoy","Software Engineer");
    }
}
