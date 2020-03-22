package com.stcodesapp.bmicalculator.common.dependencyInjection.task.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskModule
{
    private Activity activity;

    public TaskModule(Activity activity)
    {
        this.activity = activity;
    }

    @Provides
    Activity getActivity()
    {
        return activity;
    }
}
