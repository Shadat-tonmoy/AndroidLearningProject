package com.stcodesapp.bmicalculator.controller.activityController;

import android.app.Activity;

import com.stcodesapp.bmicalculator.R;
import com.stcodesapp.bmicalculator.controller.common.BaseController;
import com.stcodesapp.bmicalculator.ui.views.screen.commons.NavigationDrawerScreen;
import com.stcodesapp.bmicalculator.ui.views.screenView.commons.NavigationDrawerView;

import javax.inject.Inject;

public class NavigationDrawerController extends BaseController implements NavigationDrawerScreen.Listener
{

    private NavigationDrawerView navigationDrawerView;

    public NavigationDrawerController(Activity activity)
    {
        getTaskComponent(activity).inject(this);
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
            case R.id.home_menu:
                /*fragmentNavigationTasks.toHomeScreen();
                updateToolbarTitle(FragmentTags.HOME_SCREEN);*/
                break;
            case R.id.history_menu:
                /*activityNavigationTasks.toSavedFileActivity();*/
                break;
            case R.id.upgrade_menu:
                /*fragmentNavigationTasks.toNavigationMenu2Fragment();
                updateToolbarTitle(FragmentTags.NAVIGATION_MENU_2);*/
                break;
        }
    }
}
