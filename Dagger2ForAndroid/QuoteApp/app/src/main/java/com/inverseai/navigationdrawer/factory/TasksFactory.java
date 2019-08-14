package com.inverseai.navigationdrawer.factory;

import android.support.v4.app.FragmentActivity;
import com.inverseai.navigationdrawer.common.FragmentFrameHelper;
import com.inverseai.navigationdrawer.tasks.navigationTasks.ActivityNavigationTasks;
import com.inverseai.navigationdrawer.tasks.navigationTasks.FragmentNavigationTasks;
import com.inverseai.navigationdrawer.tasks.utilityTasks.ClipboardTasks;
import com.inverseai.navigationdrawer.tasks.utilityTasks.SharingTasks;

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


}
