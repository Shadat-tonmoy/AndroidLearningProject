package com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation;


import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;

import dagger.Component;

@Component(modules = PresentationModule.class)
public interface PresentationComponent
{
    public ViewFactory getViewFactory();
    public ControllerFactory getControllerFactory();
    public TasksFactory getTasksFactory();


}
