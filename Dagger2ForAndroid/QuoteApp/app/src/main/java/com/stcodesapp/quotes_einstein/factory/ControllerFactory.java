package com.stcodesapp.quotes_einstein.factory;

import android.app.Activity;

import com.stcodesapp.quotes_einstein.controllers.activityController.SecondActivityController;
import com.stcodesapp.quotes_einstein.controllers.fragmentController.HomeScreenController;
import com.stcodesapp.quotes_einstein.controllers.activityController.MainActivityController;
import com.stcodesapp.quotes_einstein.controllers.commons.NavigationDrawerController;
import com.stcodesapp.quotes_einstein.controllers.fragmentController.QuoteDetailController;

public class ControllerFactory {

    private TasksFactory tasksFactory;
    private Activity activity;

    public ControllerFactory(TasksFactory tasksFactory, Activity activity) {
        this.tasksFactory = tasksFactory;
        this.activity = activity;
    }

    public HomeScreenController getHomeScreenController()
    {
        return new HomeScreenController(tasksFactory);
    }

    public QuoteDetailController getQuoteDetailController()
    {
        return new QuoteDetailController(activity,tasksFactory);
    }

    public MainActivityController getMainActivityController()
    {
        return new MainActivityController(tasksFactory);
    }


    public SecondActivityController getSecondActivityController()
    {
        return new SecondActivityController(tasksFactory);
    }

    public NavigationDrawerController getNavigationDrawerController()
    {
        return new NavigationDrawerController(tasksFactory.getFragmentNavigationTasks());
    }
}
