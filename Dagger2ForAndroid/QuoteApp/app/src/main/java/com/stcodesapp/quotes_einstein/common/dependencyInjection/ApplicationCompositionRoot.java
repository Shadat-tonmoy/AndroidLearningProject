package com.stcodesapp.quotes_einstein.common.dependencyInjection;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import com.stcodesapp.quotes_einstein.common.FragmentNavigationHelper;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.application.ApplicationComponent;
import com.stcodesapp.quotes_einstein.controllers.commons.FragmentFrameWrapper;
import com.stcodesapp.quotes_einstein.database.AppDatabase;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;
import com.stcodesapp.quotes_einstein.ui.dialog.DialogManager;

public class ApplicationCompositionRoot {

    private ApplicationComponent applicationComponent;

    public ApplicationCompositionRoot(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    public AppDatabase getAppDatabase()
    {
        return applicationComponent.getAppDatabase();
    }

    /*public ViewFactory getViewFactory()
    {
        return compositionRoot.getViewFactory();
    }

    public ControllerFactory getControllerFactory()
    {
        return compositionRoot.getControllerFactory();
    }

    public TasksFactory getTasksFactory()
    {
        return compositionRoot.getTasksFactory();
    }*/









}
