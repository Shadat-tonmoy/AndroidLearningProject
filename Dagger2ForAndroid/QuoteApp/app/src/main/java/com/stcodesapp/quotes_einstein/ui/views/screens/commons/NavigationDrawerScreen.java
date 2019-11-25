package com.stcodesapp.quotes_einstein.ui.views.screens.commons;

import android.widget.FrameLayout;

import com.stcodesapp.quotes_einstein.ui.views.baseScreens.BaseObservableScreen;

public interface NavigationDrawerScreen extends BaseObservableScreen<NavigationDrawerScreen.Listener> {

    interface Listener{
        void onNavigationDrawerItemClicked(int itemId);
    }


    FrameLayout getFragmentFrame();
}
