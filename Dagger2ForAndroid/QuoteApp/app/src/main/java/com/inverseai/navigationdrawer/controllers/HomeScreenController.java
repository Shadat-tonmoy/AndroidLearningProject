package com.inverseai.navigationdrawer.controllers;

import android.os.Bundle;

import com.inverseai.navigationdrawer.R;
import com.inverseai.navigationdrawer.factory.TasksFactory;
import com.inverseai.navigationdrawer.tasks.navigationTasks.ActivityNavigationTasks;
import com.inverseai.navigationdrawer.tasks.navigationTasks.FragmentNavigationTasks;
import com.inverseai.navigationdrawer.ui.views.screens.HomeScreen;

public class HomeScreenController implements HomeScreen.Listener{


    private TasksFactory tasksFactory;
    private HomeScreen homeScreenView;
    private ActivityNavigationTasks activityNavigationTasks;
    private FragmentNavigationTasks fragmentNavigationTasks;

    public HomeScreenController(TasksFactory tasksFactory)
    {
        this.tasksFactory = tasksFactory;
        this.activityNavigationTasks = tasksFactory.getActivityNavigationTasks();
        this.fragmentNavigationTasks = tasksFactory.getFragmentNavigationTasks();
    }

    public void bindView(HomeScreen homeScreenView) {
        this.homeScreenView = homeScreenView;
    }

    public void onStart()
    {
        homeScreenView.registerListener(this);
    }

    public void onStop()
    {
        homeScreenView.unregisterListener(this);
    }


    public void onOptionMenuClicked(int menuId) {
        switch (menuId)
        {
            case R.id.popup_menu_1:
                activityNavigationTasks.toSettingsScreen(new Bundle());
                break;
            case R.id.popup_menu_2:
                break;
            case R.id.popup_menu_3:
                break;
        }
    }

}
