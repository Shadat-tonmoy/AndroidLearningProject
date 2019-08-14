package com.stcodesapp.quotes_einstein.ui.views.screens;


import com.stcodesapp.quotes_einstein.ui.views.baseScreens.BaseObservableScreen;

public interface HomeScreen extends BaseObservableScreen<HomeScreen.Listener> {

    interface Listener {

        void onOptionMenuClicked(int menuId);

    }


}
