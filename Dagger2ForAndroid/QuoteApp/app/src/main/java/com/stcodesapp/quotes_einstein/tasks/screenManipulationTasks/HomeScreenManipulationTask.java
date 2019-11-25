package com.stcodesapp.quotes_einstein.tasks.screenManipulationTasks;

import android.app.Activity;

import com.stcodesapp.quotes_einstein.models.Quotes;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.HomeScreenView;

import java.util.List;

public class HomeScreenManipulationTask
{
    private Activity activity;
    private HomeScreenView homeScreenView;


    public HomeScreenManipulationTask(Activity activity)
    {
        this.activity = activity;
    }

    public void bindView(HomeScreenView homeScreenView)
    {
        this.homeScreenView = homeScreenView;
    }

    public void bindQuotes(List<Quotes> quotesList)
    {
        homeScreenView.getQuoteListAdapter().bindQuotes(quotesList);
    }
}
