package com.shadattonmoy.androidJetPackDemo.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.shadattonmoy.androidJetPackDemo.BR;

public class Person extends BaseObservable
{
    private String name;
    private String designation;

    public Person(String name, String designation)
    {
        this.name = name;
        this.designation = designation;
    }

    @Bindable
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getDesignation()
    {
        return designation;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
        notifyPropertyChanged(BR.designation);
    }
}
