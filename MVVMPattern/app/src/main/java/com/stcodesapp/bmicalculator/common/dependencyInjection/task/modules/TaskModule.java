package com.stcodesapp.bmicalculator.common.dependencyInjection.task.modules;

import android.app.Activity;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.stcodesapp.bmicalculator.common.fragmentHelper.FragmentFrameHelper;
import com.stcodesapp.bmicalculator.common.fragmentHelper.FragmentFrameWrapper;
import com.stcodesapp.bmicalculator.tasks.navigationTask.FragmentNavigationTasks;

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

    @Provides
    FragmentNavigationTasks getFragmentNavigationTasks(FragmentFrameHelper fragmentFrameHelper)
    {
        return new FragmentNavigationTasks(fragmentFrameHelper);
    }

    @Provides
    FragmentActivity getFragmentActivity()
    {
        return (FragmentActivity) activity;
    }

    @Provides
    FragmentManager getFragmentManager(FragmentActivity activity)
    {
        return activity.getSupportFragmentManager();
    }

    @Provides
    FragmentFrameWrapper getFragmentFrameWrapper(FragmentActivity activity)
    {
        return (FragmentFrameWrapper) activity;
    }

    @Provides
    FragmentFrameHelper getFragmentFrameHelper(FragmentActivity activity, FragmentFrameWrapper fragmentFrameWrapper, FragmentManager fragmentManager)
    {
        return new FragmentFrameHelper(activity,fragmentFrameWrapper,fragmentManager);
    }
}
