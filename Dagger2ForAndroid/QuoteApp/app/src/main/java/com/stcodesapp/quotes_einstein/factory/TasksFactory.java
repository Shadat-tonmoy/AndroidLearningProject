package com.stcodesapp.quotes_einstein.factory;

import android.support.v4.app.FragmentActivity;
import com.stcodesapp.quotes_einstein.common.FragmentNavigationHelper;
import com.stcodesapp.quotes_einstein.database.AppDatabase;
import com.stcodesapp.quotes_einstein.tasks.databaseTasks.QuoteFetchingTask;
import com.stcodesapp.quotes_einstein.tasks.databaseTasks.QuoteInsertTask;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.ActivityNavigationTasks;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.FragmentNavigationTasks;
import com.stcodesapp.quotes_einstein.tasks.screenManipulationTasks.HomeScreenManipulationTask;
import com.stcodesapp.quotes_einstein.tasks.screenManipulationTasks.QuoteDetailScreenManipulationTask;
import com.stcodesapp.quotes_einstein.tasks.utilityTasks.ClipboardTasks;
import com.stcodesapp.quotes_einstein.tasks.utilityTasks.SharingTasks;

public class TasksFactory {

    private FragmentActivity activity;
    private FragmentNavigationHelper fragmentNavigationHelper;
    private AppDatabase appDatabase;

    public TasksFactory(FragmentActivity activity, FragmentNavigationHelper fragmentNavigationHelper, AppDatabase appDatabase) {
        this.activity = activity;
        this.fragmentNavigationHelper = fragmentNavigationHelper;
        this.appDatabase = appDatabase;
    }

    public TasksFactory(FragmentActivity activity, AppDatabase appDatabase) {
        this.activity = activity;

        this.appDatabase = appDatabase;
    }

    public ActivityNavigationTasks getActivityNavigationTasks()
    {
        return new ActivityNavigationTasks(activity);
    }

    public FragmentNavigationTasks getFragmentNavigationTasks()
    {
        return new FragmentNavigationTasks(fragmentNavigationHelper, activity);
    }

    public SharingTasks getSharingTasks()
    {
        return new SharingTasks(activity);
    }

    public ClipboardTasks getClipboardTasks()
    {
        return new ClipboardTasks(activity);
    }

    public QuoteInsertTask getQuoteInsertTask()
    {
        return new QuoteInsertTask(activity,appDatabase);
    }

    public QuoteFetchingTask getQuoteFetchingTask()
    {
        return new QuoteFetchingTask(activity,appDatabase);
    }

    public HomeScreenManipulationTask getHomeScreenManipulationTask()
    {
        return new HomeScreenManipulationTask(activity);
    }

    public QuoteDetailScreenManipulationTask getQuoteDetailScreenManipulationTask()
    {
        return new QuoteDetailScreenManipulationTask(activity);
    }


}
