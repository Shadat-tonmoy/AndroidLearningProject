package com.stcodesapp.quotes_einstein.common.dependencyInjection;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;

import com.stcodesapp.quotes_einstein.common.FragmentFrameHelper;
import com.stcodesapp.quotes_einstein.factory.AdapterFactory;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;

public class CompositionRoot {

    public ViewFactory getViewFactory(LayoutInflater layoutInflater, FragmentActivity fragmentActivity) {
        return new ViewFactory(layoutInflater, getAdapterFactory(fragmentActivity));
    }

    public ControllerFactory getActivityControllerFactory(FragmentActivity activity) {
        return new ControllerFactory(getTasksFactory(activity), activity);
    }


    public ControllerFactory getFragmentControllerFactory(FragmentActivity activity,FragmentFrameHelper fragmentFrameHelper) {
        return new ControllerFactory(getTasksFactory(activity,fragmentFrameHelper), activity);
    }

    public TasksFactory getTasksFactory(FragmentActivity activity) {
        return new TasksFactory(activity);
    }

    public TasksFactory getTasksFactory(FragmentActivity activity, FragmentFrameHelper fragmentFrameHelper) {
        return new TasksFactory(activity,fragmentFrameHelper);
    }

    public AdapterFactory getAdapterFactory(FragmentActivity fragmentActivity)
    {
        return new AdapterFactory(fragmentActivity);
    }


}
