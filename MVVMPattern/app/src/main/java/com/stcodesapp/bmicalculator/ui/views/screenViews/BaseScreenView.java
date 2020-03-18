package com.stcodesapp.bmicalculator.ui.views.screenViews;

import android.content.Context;
import android.view.View;

import com.stcodesapp.bmicalculator.ui.views.screen.BaseScreen;

public abstract class BaseScreenView implements BaseScreen
{
    private View rootView;

    @Override
    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    public Context getContext()
    {
        return rootView.getContext();
    }

    public <T extends View> T findViewById(int id)
    {
        return rootView.findViewById(id);
    }
}
