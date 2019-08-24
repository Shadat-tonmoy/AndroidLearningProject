package com.stcodesapp.quotes_einstein.common.dependencyInjection.application;

import com.stcodesapp.quotes_einstein.database.AppDatabase;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent
{
    public AppDatabase getAppDatabase();
}
