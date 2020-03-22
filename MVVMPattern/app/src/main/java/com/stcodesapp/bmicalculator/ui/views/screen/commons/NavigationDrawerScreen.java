package com.stcodesapp.bmicalculator.ui.views.screen.commons;

import android.widget.FrameLayout;

public interface NavigationDrawerScreen extends BaseObservableScreen<NavigationDrawerScreen.Listener> {

    interface Listener{
        void onNavigationDrawerItemClicked(int itemId);
    }
}
