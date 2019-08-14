package com.stcodesapp.quotes_einstein.factory;

import android.support.v4.app.FragmentActivity;
import com.stcodesapp.quotes_einstein.common.FragmentFrameHelper;
import com.stcodesapp.quotes_einstein.tasks.databaseTasks.QuoteFetchingTask;
import com.stcodesapp.quotes_einstein.tasks.databaseTasks.QuoteInsertTask;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.ActivityNavigationTasks;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.FragmentNavigationTasks;
import com.stcodesapp.quotes_einstein.tasks.utilityTasks.ClipboardTasks;
import com.stcodesapp.quotes_einstein.tasks.utilityTasks.SharingTasks;

public class TasksFactory {

    private FragmentActivity activity;
    private FragmentFrameHelper fragmentFrameHelper;

    public TasksFactory(FragmentActivity activity, FragmentFrameHelper fragmentFrameHelper) {
        this.activity = activity;
        this.fragmentFrameHelper= fragmentFrameHelper;
    }

    public TasksFactory(FragmentActivity activity) {
        this.activity = activity;

    }

    public ActivityNavigationTasks getActivityNavigationTasks()
    {
        return new ActivityNavigationTasks(activity);
    }

    public FragmentNavigationTasks getFragmentNavigationTasks()
    {
        return new FragmentNavigationTasks(fragmentFrameHelper);
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
        return new QuoteInsertTask(activity);
    }

    public QuoteFetchingTask getQuoteFetchingTask()
    {
        return new QuoteFetchingTask(activity);
    }


}
