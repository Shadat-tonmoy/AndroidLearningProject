package com.stcodesapp.bmicalculator.tasks.navigationTask;

import com.stcodesapp.bmicalculator.common.fragmentHelper.FragmentFrameHelper;
import com.stcodesapp.bmicalculator.constants.values.Tags;
import com.stcodesapp.bmicalculator.ui.fragments.HomeScreenFragment;

public class FragmentNavigationTasks {

    private FragmentFrameHelper fragmentFrameHelper;

    public FragmentNavigationTasks(FragmentFrameHelper fragmentFrameHelper) {
        this.fragmentFrameHelper= fragmentFrameHelper;
    }

    public void toHomeScreen()
    {
        fragmentFrameHelper.replaceFragmentAndClearBackstack(HomeScreenFragment.newInstance(), Tags.HOME_SCREEN);
    }
}
