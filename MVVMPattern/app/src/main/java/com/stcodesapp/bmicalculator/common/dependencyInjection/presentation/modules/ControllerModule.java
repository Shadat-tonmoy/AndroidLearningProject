package com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.modules;

import android.app.Activity;

import com.stcodesapp.bmicalculator.controller.activityController.MainActivityController;
import com.stcodesapp.bmicalculator.controller.activityController.NavigationDrawerController;

import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule
{
    @Provides
    MainActivityController getMainActivityController(Activity activity)
    {
        return new MainActivityController(activity);
    }


    @Provides
    NavigationDrawerController getNavigationDrawerController(Activity activity)
    {
        return new NavigationDrawerController(activity);
    }


}
