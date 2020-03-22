package com.stcodesapp.bmicalculator.common.dependencyInjection.task;

import com.stcodesapp.bmicalculator.common.dependencyInjection.task.modules.TaskModule;
import com.stcodesapp.bmicalculator.controller.activityController.NavigationDrawerController;

import dagger.Component;

@Component(modules = TaskModule.class)
public interface TaskComponent
{

    void inject(NavigationDrawerController navigationDrawerController);

}
