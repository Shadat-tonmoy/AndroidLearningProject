package com.stcodesapp.quotes_einstein.factory;

import com.stcodesapp.quotes_einstein.controllers.HomeScreenController;
import com.stcodesapp.quotes_einstein.controllers.activityController.MainActivityController;
import com.stcodesapp.quotes_einstein.controllers.commons.NavigationDrawerController;

public class ControllerFactory {

    private TasksFactory tasksFactory;

    public ControllerFactory(TasksFactory tasksFactory) {
        this.tasksFactory = tasksFactory;
    }

    public HomeScreenController getHomeScreenController()
    {
        return new HomeScreenController(tasksFactory);
    }

    public MainActivityController getMainActivityController()
    {
        return new MainActivityController(tasksFactory);
    }


    public com.stcodesapp.quotes_einstein.controllers.activityController.SecondActivityController getSecondActivityController()
    {
        return new com.stcodesapp.quotes_einstein.controllers.activityController.SecondActivityController(tasksFactory);
    }

    public NavigationDrawerController getNavigationDrawerController()
    {
        return new NavigationDrawerController(tasksFactory.getFragmentNavigationTasks());
    }
}
