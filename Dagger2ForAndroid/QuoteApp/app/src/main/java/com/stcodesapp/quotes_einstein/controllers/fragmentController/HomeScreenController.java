package com.stcodesapp.quotes_einstein.controllers.fragmentController;

import android.os.Bundle;

import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.models.Quotes;
import com.stcodesapp.quotes_einstein.tasks.databaseTasks.QuoteFetchingTask;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.ActivityNavigationTasks;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.FragmentNavigationTasks;
import com.stcodesapp.quotes_einstein.tasks.screenManipulationTasks.HomeScreenManipulationTask;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.HomeScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screens.HomeScreen;

import java.util.List;

public class HomeScreenController implements HomeScreen.Listener, QuoteFetchingTask.Listener
{


    private TasksFactory tasksFactory;
    private HomeScreenView homeScreenView;
    private ActivityNavigationTasks activityNavigationTasks;
    private FragmentNavigationTasks fragmentNavigationTasks;
    private HomeScreenManipulationTask homeScreenManipulationTask;
    private boolean isQuotesFetched = false;

    public HomeScreenController(TasksFactory tasksFactory)
    {
        this.tasksFactory = tasksFactory;
        this.activityNavigationTasks = tasksFactory.getActivityNavigationTasks();
        this.fragmentNavigationTasks = tasksFactory.getFragmentNavigationTasks();
        this.homeScreenManipulationTask = tasksFactory.getHomeScreenManipulationTask();
    }

    public void bindView(HomeScreenView homeScreenView)
    {
        this.homeScreenView = homeScreenView;
        homeScreenManipulationTask.bindView(homeScreenView);
    }

    public void onStart()
    {
        homeScreenView.registerListener(this);
        if(!isQuotesFetched)
            startFetchingQuotes();
    }

    public void onStop()
    {
        homeScreenView.unregisterListener(this);
    }

    private void startFetchingQuotes()
    {
        QuoteFetchingTask quoteFetchingTask = tasksFactory.getQuoteFetchingTask();
        quoteFetchingTask.setListener(this);
        quoteFetchingTask.execute();
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

    @Override
    public void onQuoteListFetched(List<Quotes> quotes)
    {
        homeScreenManipulationTask.bindQuotes(quotes);
        isQuotesFetched = true;
    }
}
