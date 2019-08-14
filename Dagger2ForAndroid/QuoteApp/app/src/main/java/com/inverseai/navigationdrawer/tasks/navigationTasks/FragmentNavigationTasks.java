package com.inverseai.navigationdrawer.tasks.navigationTasks;
import com.inverseai.navigationdrawer.common.FragmentFrameHelper;
import com.inverseai.navigationdrawer.constants.FragmentTags;
import com.inverseai.navigationdrawer.ui.fragments.HomeScreenFragment;
import com.inverseai.navigationdrawer.ui.fragments.NavigationMenu1Fragment;
import com.inverseai.navigationdrawer.ui.fragments.NavigationMenu2Fragment;

public class FragmentNavigationTasks {

    private FragmentFrameHelper fragmentFrameHelper;

    public FragmentNavigationTasks(FragmentFrameHelper fragmentFrameHelper) {
        this.fragmentFrameHelper= fragmentFrameHelper;

    }


    public void toHomeScreen()
    {
        fragmentFrameHelper.replaceFragmentAndClearBackstack(HomeScreenFragment.newInstance(),FragmentTags.HOME_SCREEN);
    }


    public void toNavigationMenu1Fragment()
    {
        fragmentFrameHelper.replaceFragment(NavigationMenu1Fragment.newInstance(), FragmentTags.NAVIGATION_MENU_1);

    }

    public void toNavigationMenu2Fragment()
    {
        fragmentFrameHelper.replaceFragment(NavigationMenu2Fragment.newInstance(), FragmentTags.NAVIGATION_MENU_2);

    }

    public String getCurrentFragmentTag()
    {
        return fragmentFrameHelper.getCurrentFragment().getTag();
    }
}
