package com.inverseai.navigationdrawer.controllers.activityController;

import android.util.Log;

import com.inverseai.navigationdrawer.R;
import com.inverseai.navigationdrawer.factory.TasksFactory;
import com.inverseai.navigationdrawer.tasks.navigationTasks.FragmentNavigationTasks;
import com.inverseai.navigationdrawer.ui.commons.NavigationDrawerView;
import com.inverseai.navigationdrawer.ui.views.screens.commons.NavigationDrawerScreen;

public class MainActivityController implements NavigationDrawerScreen.Listener {

    private TasksFactory tasksFactory;
    private NavigationDrawerView navigationDrawerView;
    private FragmentNavigationTasks fragmentNavigationTasks;

    public MainActivityController(TasksFactory tasksFactory) {
        this.tasksFactory = tasksFactory;
        this.fragmentNavigationTasks = tasksFactory.getFragmentNavigationTasks();
    }

    public void bindView(NavigationDrawerView navigationDrawerView) {
        this.navigationDrawerView = navigationDrawerView;
    }

    public void onStart()
    {
        navigationDrawerView.registerListener(this);
    }

    public void onStop()
    {
        navigationDrawerView.unregisterListener(this);
    }

    @Override
    public void onNavigationDrawerItemClicked(int itemId) {
        switch (itemId)
        {
            case R.id.nav_menu_1:
                fragmentNavigationTasks.toHomeScreen();
                break;
            case R.id.nav_menu_2:
                fragmentNavigationTasks.toNavigationMenu1Fragment();
                break;


        }


    }
}
