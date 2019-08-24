package com.stcodesapp.quotes_einstein.common.dependencyInjection.application;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import com.stcodesapp.quotes_einstein.common.CustomApplication;
import com.stcodesapp.quotes_einstein.common.FragmentNavigationHelper;
import com.stcodesapp.quotes_einstein.controllers.commons.FragmentFrameWrapper;
import com.stcodesapp.quotes_einstein.database.AppDatabase;
import com.stcodesapp.quotes_einstein.factory.AdapterFactory;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule
{

    private CustomApplication application;

    public ApplicationModule(CustomApplication application) {
        this.application= application;
    }

    //these dependencies resides inside application lifecycle
    @Provides
    AppDatabase getAppDatabase()
    {
        return AppDatabase.getInstance(getApplication());
    }

    @Provides
    CustomApplication getApplication()
    {
        return application;
    }
}
