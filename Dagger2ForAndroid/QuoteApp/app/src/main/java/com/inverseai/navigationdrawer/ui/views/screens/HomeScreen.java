package com.inverseai.navigationdrawer.ui.views.screens;


import com.inverseai.navigationdrawer.ui.views.baseScreens.BaseObservableScreen;

public interface HomeScreen extends BaseObservableScreen<HomeScreen.Listener> {

    interface Listener {

        void onOptionMenuClicked(int menuId);

    }


}
