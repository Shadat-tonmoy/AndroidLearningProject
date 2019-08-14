package com.inverseai.navigationdrawer.factory;

import com.inverseai.navigationdrawer.controllers.HomeScreenController;
import com.inverseai.navigationdrawer.controllers.activityController.SecondActivityController;
import com.inverseai.navigationdrawer.controllers.activityController.MainActivityController;
import com.inverseai.navigationdrawer.controllers.commons.NavigationDrawerController;

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


    public com.inverseai.navigationdrawer.controllers.activityController.SecondActivityController getSecondActivityController()
    {
        return new com.inverseai.navigationdrawer.controllers.activityController.SecondActivityController(tasksFactory);
    }

    public NavigationDrawerController getNavigationDrawerController()
    {
        return new NavigationDrawerController(tasksFactory.getFragmentNavigationTasks());
    }
}
