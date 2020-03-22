package com.stcodesapp.bmicalculator.controller.common;

import android.app.Activity;

import com.stcodesapp.bmicalculator.common.dependencyInjection.task.DaggerTaskComponent;
import com.stcodesapp.bmicalculator.common.dependencyInjection.task.TaskComponent;
import com.stcodesapp.bmicalculator.common.dependencyInjection.task.modules.TaskModule;

public class BaseController
{
    public TaskComponent getTaskComponent(Activity activity)
    {
        return DaggerTaskComponent
                .builder()
                .taskModule(new TaskModule(activity))
                .build();
    }

}
