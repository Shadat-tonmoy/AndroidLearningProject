package com.stcodesapp.quotes_einstein.common.dependencyInjection;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;

import com.stcodesapp.quotes_einstein.common.FragmentFrameHelper;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;

public class CompositionRoot {

    public ViewFactory getViewFactory(LayoutInflater layoutInflater) {
        return new ViewFactory(layoutInflater);
    }

    public ControllerFactory getActivityControllerFactory(FragmentActivity activity) {
        return new ControllerFactory(getTasksFactory(activity));
    }


    public ControllerFactory getFragmentControllerFactory(FragmentActivity activity,FragmentFrameHelper fragmentFrameHelper) {
        return new ControllerFactory(getTasksFactory(activity,fragmentFrameHelper));
    }

    public TasksFactory getTasksFactory(FragmentActivity activity) {
        return new TasksFactory(activity);
    }

    public TasksFactory getTasksFactory(FragmentActivity activity, FragmentFrameHelper fragmentFrameHelper) {
        return new TasksFactory(activity,fragmentFrameHelper);
    }
}
