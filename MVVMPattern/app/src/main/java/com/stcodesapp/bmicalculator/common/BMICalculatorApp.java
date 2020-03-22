package com.stcodesapp.bmicalculator.common;

import android.app.Application;

import com.stcodesapp.bmicalculator.common.dependencyInjection.application.ApplicationComponent;
import com.stcodesapp.bmicalculator.common.dependencyInjection.application.ApplicationModule;
import com.stcodesapp.bmicalculator.common.dependencyInjection.application.DaggerApplicationComponent;

public class BMICalculatorApp extends Application
{

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();

    }

    public ApplicationComponent getApplicationComponent()
    {
        if(applicationComponent==null)
        {
            applicationComponent = DaggerApplicationComponent
                    .builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return applicationComponent;
    }
}
