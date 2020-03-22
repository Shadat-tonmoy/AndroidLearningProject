package com.stcodesapp.bmicalculator.factory;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.stcodesapp.bmicalculator.ui.views.screenView.activityScreenViews.MainActivityScreenView;

public class ViewFactory
{
    private LayoutInflater layoutInflater;

    public ViewFactory(LayoutInflater layoutInflater)
    {
        this.layoutInflater = layoutInflater;
    }

    public MainActivityScreenView getMainActivityScreenView(@Nullable ViewGroup parent)
    {
        return new MainActivityScreenView(layoutInflater,parent);
    }
}
