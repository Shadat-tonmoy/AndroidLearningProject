package com.inverseai.navigationdrawer.ui.views.screens.commons;

import android.widget.FrameLayout;

import com.inverseai.navigationdrawer.ui.views.baseScreens.BaseObservableScreen;

public interface NavigationDrawerScreen extends BaseObservableScreen<NavigationDrawerScreen.Listener> {

    interface Listener{
        void onNavigationDrawerItemClicked(int itemId);
    }


    FrameLayout getFragmentFrame();
}
