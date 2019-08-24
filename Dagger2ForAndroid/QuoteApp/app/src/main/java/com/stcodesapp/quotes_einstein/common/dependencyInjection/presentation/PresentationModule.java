package com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import com.stcodesapp.quotes_einstein.common.FragmentNavigationHelper;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.application.ApplicationComponent;
import com.stcodesapp.quotes_einstein.controllers.commons.FragmentFrameWrapper;
import com.stcodesapp.quotes_einstein.database.AppDatabase;
import com.stcodesapp.quotes_einstein.factory.AdapterFactory;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule
{

    private final FragmentActivity activity;
    private final ApplicationComponent applicationComponent;

    public PresentationModule(FragmentActivity activity, ApplicationComponent applicationComponent) {
        this.activity = activity;
        this.applicationComponent = applicationComponent;
    }

    //these dependencies resides inside activity lifecycle
    @Provides
    ViewFactory getViewFactory(LayoutInflater layoutInflater, AdapterFactory adapterFactory) {
        return new ViewFactory(layoutInflater, adapterFactory);
    }

    @Provides
    ControllerFactory getControllerFactory(FragmentActivity activity, TasksFactory tasksFactory) {
        return new ControllerFactory(tasksFactory, activity);
    }

    @Provides
    TasksFactory getTasksFactory(FragmentActivity activity, FragmentNavigationHelper fragmentNavigationHelper, AppDatabase appDatabase) {
        return new TasksFactory(activity, fragmentNavigationHelper, appDatabase);
    }

    @Provides
    AdapterFactory getAdapterFactory(FragmentActivity fragmentActivity)
    {
        return new AdapterFactory(fragmentActivity);
    }

    @Provides
    FragmentActivity getActivity()
    {
        return activity;
    }

    @Provides
    LayoutInflater getLayoutInflater(FragmentActivity activity)
    {
        return activity.getLayoutInflater();
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
    FragmentNavigationHelper getFragmentNavigationHelper(FragmentActivity activity, FragmentFrameWrapper fragmentFrameWrapper, FragmentManager fragmentManager)
    {
        return new FragmentNavigationHelper(activity,fragmentFrameWrapper,fragmentManager);
    }

    @Provides
    AppDatabase getAppDatabase()
    {
        return applicationComponent.getAppDatabase();
    }
}
