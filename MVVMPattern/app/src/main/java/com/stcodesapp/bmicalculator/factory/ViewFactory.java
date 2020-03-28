package com.stcodesapp.bmicalculator.factory;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.stcodesapp.bmicalculator.ui.views.screenView.activityScreenViews.HomeScreenView;
import com.stcodesapp.bmicalculator.ui.views.screenView.commons.NavigationDrawerView;

public class ViewFactory
{
    private LayoutInflater layoutInflater;

    public ViewFactory(LayoutInflater layoutInflater)
    {
        this.layoutInflater = layoutInflater;
    }

    public HomeScreenView getMainActivityScreenView(@Nullable ViewGroup parent)
    {
        return new HomeScreenView(layoutInflater,parent);
    }

    public NavigationDrawerView getNavigationDrawerView(@Nullable ViewGroup parent)
    {
        return new NavigationDrawerView(layoutInflater,parent);
    }
}
