package com.stcodesapp.bmicalculator.ui.views.screen.activityScreen;

import com.stcodesapp.bmicalculator.ui.views.screen.commons.BaseObservableScreen;

public interface MainActivityScreen extends BaseObservableScreen<MainActivityScreen.Listener>
{
    interface Listener
    {
        void onGenerateRandomNumberButtonClicked();

    }
}
