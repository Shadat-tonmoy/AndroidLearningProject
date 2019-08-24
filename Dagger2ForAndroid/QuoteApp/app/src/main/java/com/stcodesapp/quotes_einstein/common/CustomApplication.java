package com.stcodesapp.quotes_einstein.common;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.FragmentActivity;

import com.stcodesapp.quotes_einstein.common.dependencyInjection.CompositionRoot;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.application.ApplicationComponent;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.application.ApplicationModule;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.application.DaggerApplicationComponent;

public class CustomApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent()
    {
        return applicationComponent;
    }
}
