package com.inverseai.navigationdrawer.common.dependencyInjection;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;

import com.inverseai.navigationdrawer.common.FragmentFrameHelper;
import com.inverseai.navigationdrawer.factory.ControllerFactory;
import com.inverseai.navigationdrawer.factory.TasksFactory;
import com.inverseai.navigationdrawer.factory.ViewFactory;

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
