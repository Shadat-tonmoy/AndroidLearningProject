package com.stcodesapp.bmicalculator.ui.views.screen.commons;

public interface BottomNavigationScreen extends BaseObservableScreen<BottomNavigationScreen.Listener> {

    interface Listener
    {
        void onBottomNavigationItemClicked(int itemId);
    }
}
