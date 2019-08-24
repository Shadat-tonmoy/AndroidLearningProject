package com.stcodesapp.quotes_einstein.common.dependencyInjection.application;

import com.stcodesapp.quotes_einstein.database.AppDatabase;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent
{
    public AppDatabase getAppDatabase();
}
