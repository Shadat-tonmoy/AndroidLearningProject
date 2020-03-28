package com.stcodesapp.bmicalculator.ui.views.screen.activityScreen;

import com.stcodesapp.bmicalculator.ui.views.screen.commons.BaseObservableScreen;

public interface HomeScreen extends BaseObservableScreen<HomeScreen.Listener>
{
    interface Listener
    {
        void onGenerateRandomNumberButtonClicked();

    }
}
