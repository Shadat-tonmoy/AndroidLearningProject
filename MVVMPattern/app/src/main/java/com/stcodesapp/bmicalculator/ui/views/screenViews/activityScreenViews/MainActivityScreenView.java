package com.stcodesapp.bmicalculator.ui.views.screenViews.activityScreenViews;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.stcodesapp.bmicalculator.R;
import com.stcodesapp.bmicalculator.ui.views.screen.activityScreens.MainActivityScreen;
import com.stcodesapp.bmicalculator.ui.views.screenViews.commons.BaseObservableScreenView;

public class MainActivityScreenView extends BaseObservableScreenView<MainActivityScreen.Listener>
{
    public MainActivityScreenView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup parent)
    {
        setRootView(layoutInflater.inflate(R.layout.activity_main,parent,false));
        inflateUIElements();
        initUserInteractions();
    }

    @Override
    public void inflateUIElements()
    {

    }

    @Override
    public void initUserInteractions()
    {


    }
}
