package com.stcodesapp.quotes_einstein.tasks.navigationTasks;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.common.FragmentFrameHelper;
import com.stcodesapp.quotes_einstein.constants.Tags;
import com.stcodesapp.quotes_einstein.ui.fragments.HomeScreenFragment;
import com.stcodesapp.quotes_einstein.ui.fragments.NavigationMenu1Fragment;
import com.stcodesapp.quotes_einstein.ui.fragments.NavigationMenu2Fragment;
import com.stcodesapp.quotes_einstein.ui.fragments.QuoteDetailFragment;

public class FragmentNavigationTasks {

    private FragmentFrameHelper fragmentFrameHelper;
    private Activity activity;

    public FragmentNavigationTasks(FragmentFrameHelper fragmentFrameHelper, Activity activity) {
        this.fragmentFrameHelper= fragmentFrameHelper;

        this.activity = activity;
    }


    public void toHomeScreen()
    {
        fragmentFrameHelper.replaceFragmentAndClearBackstack(HomeScreenFragment.newInstance(), Tags.HOME);
    }

    public void toQuoteDetailFragment(Bundle args)
    {
        fragmentFrameHelper.replaceFragment(QuoteDetailFragment.newInstance(args),Tags.QUOTES);
        updateToolbarTitle(Tags.QUOTES);
    }


    public void toNavigationMenu1Fragment()
    {
        fragmentFrameHelper.replaceFragment(NavigationMenu1Fragment.newInstance(), Tags.NAVIGATION_MENU_1);

    }

    public void toNavigationMenu2Fragment()
    {
        fragmentFrameHelper.replaceFragment(NavigationMenu2Fragment.newInstance(), Tags.NAVIGATION_MENU_2);

    }

    public String getCurrentFragmentTag()
    {
        return fragmentFrameHelper.getCurrentFragment().getTag();
    }

    private void updateToolbarTitle(String title)
    {
        Toolbar toolbar  = activity.findViewById(R.id.app_toolbar);
        toolbar.setTitle(title);
    }
}
