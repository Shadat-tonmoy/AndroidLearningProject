package com.stcodesapp.quotes_einstein.tasks.navigationTasks;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.common.FragmentNavigationHelper;
import com.stcodesapp.quotes_einstein.constants.Tags;
import com.stcodesapp.quotes_einstein.ui.activities.CanvasActivity;
import com.stcodesapp.quotes_einstein.ui.fragments.HomeScreenFragment;
import com.stcodesapp.quotes_einstein.ui.fragments.NavigationMenu1Fragment;
import com.stcodesapp.quotes_einstein.ui.fragments.NavigationMenu2Fragment;
import com.stcodesapp.quotes_einstein.ui.fragments.QuoteDetailFragment;

public class FragmentNavigationTasks {

    private FragmentNavigationHelper fragmentNavigationHelper;
    private Activity activity;

    public FragmentNavigationTasks(FragmentNavigationHelper fragmentNavigationHelper, Activity activity) {
        this.fragmentNavigationHelper = fragmentNavigationHelper;

        this.activity = activity;
    }


    public void toHomeScreen()
    {
        fragmentNavigationHelper.replaceFragmentAndClearBackstack(HomeScreenFragment.newInstance(), Tags.HOME);
    }

    public void toQuoteDetailFragment(Bundle args)
    {
        fragmentNavigationHelper.replaceFragment(QuoteDetailFragment.newInstance(args),Tags.QUOTES);
        updateToolbarTitle(Tags.QUOTES);
    }


    public void toNavigationMenu1Fragment()
    {
        fragmentNavigationHelper.replaceFragment(NavigationMenu1Fragment.newInstance(), Tags.NAVIGATION_MENU_1);

    }

    public void toNavigationMenu2Fragment()
    {
        fragmentNavigationHelper.replaceFragment(NavigationMenu2Fragment.newInstance(), Tags.NAVIGATION_MENU_2);

    }

    public void toCanvasScreen()
    {
        Intent intent = new Intent(activity, CanvasActivity.class);
        activity.startActivity(intent);
    }

    public String getCurrentFragmentTag()
    {
        return fragmentNavigationHelper.getCurrentFragment().getTag();
    }

    private void updateToolbarTitle(String title)
    {
        Toolbar toolbar  = activity.findViewById(R.id.app_toolbar);
        toolbar.setTitle(title);
    }


}
