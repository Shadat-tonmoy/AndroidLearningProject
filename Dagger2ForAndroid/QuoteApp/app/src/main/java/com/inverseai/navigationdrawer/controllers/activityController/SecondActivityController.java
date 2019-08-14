package com.inverseai.navigationdrawer.controllers.activityController;

import com.inverseai.navigationdrawer.factory.TasksFactory;
import com.inverseai.navigationdrawer.tasks.navigationTasks.ActivityNavigationTasks;
import com.inverseai.navigationdrawer.ui.views.screenViews.SecondActivityScreenView;
import com.inverseai.navigationdrawer.ui.views.screens.activityScreen.SecondActivityScreen;

public class SecondActivityController implements SecondActivityScreen.Listener {

    private TasksFactory tasksFactory;
    private ActivityNavigationTasks activityNavigationTasks;
    private SecondActivityScreenView secondActivityScreenView;

    public SecondActivityController(TasksFactory tasksFactory) {
        this.tasksFactory = tasksFactory;
        activityNavigationTasks = tasksFactory.getActivityNavigationTasks();
    }

    public void bindView(SecondActivityScreenView secondActivityScreenView) {
        this.secondActivityScreenView = secondActivityScreenView;
    }

    public void onStart()
    {
        secondActivityScreenView.registerListener(this);
    }

    public void onStop()
    {
        secondActivityScreenView.unregisterListener(this);
    }


    @Override
    public void onNavigateUp() {
        activityNavigationTasks.closeScreen();
    }

    public void onPostCreate() {
        secondActivityScreenView.initUserInteractions();
    }
}
