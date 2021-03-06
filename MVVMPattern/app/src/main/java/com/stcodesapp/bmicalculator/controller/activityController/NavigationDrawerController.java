package com.stcodesapp.bmicalculator.controller.activityController;

import android.app.Activity;
import android.util.Log;

import com.stcodesapp.bmicalculator.R;
import com.stcodesapp.bmicalculator.controller.common.BaseController;
import com.stcodesapp.bmicalculator.tasks.navigationTask.FragmentNavigationTasks;
import com.stcodesapp.bmicalculator.ui.views.screen.commons.NavigationDrawerScreen;
import com.stcodesapp.bmicalculator.ui.views.screenView.commons.NavigationDrawerScreenView;

import javax.inject.Inject;

public class NavigationDrawerController extends BaseController implements NavigationDrawerScreen.Listener
{

    private static final String TAG = "NavigationDrawerControl";
    private NavigationDrawerScreenView navigationDrawerScreenView;
    @Inject FragmentNavigationTasks fragmentNavigationTasks;

    public NavigationDrawerController(Activity activity)
    {
        getTaskComponent(activity).inject(this);
    }

    public void bindView(NavigationDrawerScreenView navigationDrawerScreenView) {
        this.navigationDrawerScreenView = navigationDrawerScreenView;
    }

    public void onStart()
    {
        navigationDrawerScreenView.registerListener(this);
    }

    public void onStop()
    {
        navigationDrawerScreenView.unregisterListener(this);
    }

    public void onPostCreate()
    {
        fragmentNavigationTasks.toHomeScreen();
    }

    @Override
    public void onNavigationDrawerItemClicked(int itemId) {
        switch (itemId)
        {
            case R.id.home_menu:
                Log.e(TAG, "onNavigationDrawerItemClicked: HomeMenu");
                break;
            case R.id.history_menu:
                Log.e(TAG, "onNavigationDrawerItemClicked: HistoryMenu");
                /*activityNavigationTasks.toSavedFileActivity();*/
                break;
            case R.id.upgrade_menu:
                Log.e(TAG, "onNavigationDrawerItemClicked: UpgradeMenu");
                /*fragmentNavigationTasks.toNavigationMenu2Fragment();
                updateToolbarTitle(FragmentTags.NAVIGATION_MENU_2);*/
                break;
        }
    }
}
