package com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.modules;

import android.app.Activity;

import com.stcodesapp.bmicalculator.controller.activityController.BottomNavigationController;
import com.stcodesapp.bmicalculator.controller.fragmentController.HomeFragmentController;
import com.stcodesapp.bmicalculator.controller.activityController.NavigationDrawerController;

import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule
{
    @Provides
    HomeFragmentController getMainActivityController(Activity activity)
    {
        return new HomeFragmentController(activity);
    }


    @Provides
    NavigationDrawerController getNavigationDrawerController(Activity activity)
    {
        return new NavigationDrawerController(activity);
    }

    @Provides
    BottomNavigationController getBottomNavigationController(Activity activity)
    {
        return new BottomNavigationController(activity);
    }


}
