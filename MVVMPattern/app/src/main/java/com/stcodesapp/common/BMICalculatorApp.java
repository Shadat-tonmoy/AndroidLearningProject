package com.stcodesapp.common;

import android.app.Application;

import com.stcodesapp.common.dependencyInjection.application.ApplicationComponent;
import com.stcodesapp.common.dependencyInjection.application.ApplicationModule;
import com.stcodesapp.common.dependencyInjection.application.DaggerApplicationComponent;

public class BMICalculatorApp extends Application
{

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();

    }

    ApplicationComponent getApplicationComponent()
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
