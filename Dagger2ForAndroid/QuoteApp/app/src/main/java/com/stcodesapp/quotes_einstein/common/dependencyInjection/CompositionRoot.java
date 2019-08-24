package com.stcodesapp.quotes_einstein.common.dependencyInjection;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;

import com.stcodesapp.quotes_einstein.common.FragmentNavigationHelper;
import com.stcodesapp.quotes_einstein.factory.AdapterFactory;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;

public class CompositionRoot {

    public ViewFactory getViewFactory(LayoutInflater layoutInflater, FragmentActivity fragmentActivity) {
        return new ViewFactory(layoutInflater, getAdapterFactory(fragmentActivity));
    }

    public ControllerFactory getControllerFactory(FragmentActivity activity, FragmentNavigationHelper fragmentNavigationHelper) {
        return new ControllerFactory(getTasksFactory(activity, fragmentNavigationHelper), activity);
    }

    public TasksFactory getTasksFactory(FragmentActivity activity, FragmentNavigationHelper fragmentNavigationHelper) {
        return new TasksFactory(activity, fragmentNavigationHelper, null);
    }

    public AdapterFactory getAdapterFactory(FragmentActivity fragmentActivity)
    {
        return new AdapterFactory(fragmentActivity);
    }




}
