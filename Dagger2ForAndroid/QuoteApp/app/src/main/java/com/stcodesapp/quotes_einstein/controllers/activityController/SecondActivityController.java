package com.stcodesapp.quotes_einstein.controllers.activityController;

import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.ActivityNavigationTasks;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.SecondActivityScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screens.activityScreen.SecondActivityScreen;

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
