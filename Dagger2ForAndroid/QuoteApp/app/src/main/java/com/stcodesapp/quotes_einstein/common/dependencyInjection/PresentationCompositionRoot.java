package com.stcodesapp.quotes_einstein.common.dependencyInjection;

import com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation.PresentationComponent;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;

public class PresentationCompositionRoot
{
    private PresentationComponent presentationComponent;

    public PresentationCompositionRoot(PresentationComponent presentationComponent) {
        this.presentationComponent = presentationComponent;
    }

    public ViewFactory getViewFactory()
    {
        return presentationComponent.getViewFactory();
    }

    public ControllerFactory getControllerFactory()
    {
        return presentationComponent.getControllerFactory();
    }

    public TasksFactory getTasksFactory()
    {
        return presentationComponent.getTasksFactory();
    }
}
