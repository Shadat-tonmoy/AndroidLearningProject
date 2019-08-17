package com.stcodesapp.quotes_einstein.controllers.commons;
import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.constants.FragmentTags;
import com.stcodesapp.quotes_einstein.tasks.navigationTasks.FragmentNavigationTasks;
import com.stcodesapp.quotes_einstein.ui.commons.NavigationDrawerView;
import com.stcodesapp.quotes_einstein.ui.views.screens.commons.NavigationDrawerScreen;

public class NavigationDrawerController implements NavigationDrawerScreen.Listener {

    private final FragmentNavigationTasks fragmentNavigationTasks;
    private NavigationDrawerView navigationDrawerView;

    public NavigationDrawerController(FragmentNavigationTasks fragmentNavigationTasks) {
        this.fragmentNavigationTasks = fragmentNavigationTasks;
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
            case R.id.home_screen:
                fragmentNavigationTasks.toHomeScreen();
                updateToolbarTitle(FragmentTags.HOME);
                break;
            case R.id.nav_menu_1:
                fragmentNavigationTasks.toNavigationMenu1Fragment();
                updateToolbarTitle(FragmentTags.NAVIGATION_MENU_1);
                break;
            case R.id.nav_menu_2:
                fragmentNavigationTasks.toNavigationMenu2Fragment();
                updateToolbarTitle(FragmentTags.NAVIGATION_MENU_2);
                break;
        }
    }

    private void updateToolbarTitle(String title)
    {
        navigationDrawerView.getToolbar().setTitle(title);
        switch (title)
        {
            case FragmentTags.HOME:
                navigationDrawerView.checkMenuItem(R.id.home_screen);
                break;
            case FragmentTags.NAVIGATION_MENU_1:
                navigationDrawerView.checkMenuItem(R.id.nav_menu_1);
                break;
            case FragmentTags.NAVIGATION_MENU_2:
                navigationDrawerView.checkMenuItem(R.id.nav_menu_2);
                break;
        }
    }


    public void onBackPressed() {
        updateToolbarTitle(fragmentNavigationTasks.getCurrentFragmentTag());
    }

    public void onPostCreate() {
        fragmentNavigationTasks.toHomeScreen();
        updateToolbarTitle(FragmentTags.HOME);
    }
}
