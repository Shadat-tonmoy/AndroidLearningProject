package com.stcodesapp.quotes_einstein.tasks.navigationTasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.stcodesapp.quotes_einstein.ui.activities.SecondActivity;

public class ActivityNavigationTasks {

    private Activity activity;

    public ActivityNavigationTasks(Activity activity) {
        this.activity = activity;
    }

    public void toSettingsScreen(Bundle args)
    {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtras(args);
        activity.startActivity(intent);
    }

    public void closeScreen()
    {
        activity.finish();
    }
}
