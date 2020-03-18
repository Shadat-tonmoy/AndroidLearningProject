package com.stcodesapp.bmicalculator.ui.views.screen.commons;

import android.view.View;

public interface BaseScreen
{
    View getRootView();

    void setRootView(View view);

    void inflateUIElements();

}
