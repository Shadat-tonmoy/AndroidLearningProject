package com.stcodesapp.quotes_einstein.controllers;

import android.os.Bundle;

import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.ActivityNavigationTasks;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.FragmentNavigationTasks;
import com.stcodesapp.quotes_einstein.ui.views.screens.HomeScreen;

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
