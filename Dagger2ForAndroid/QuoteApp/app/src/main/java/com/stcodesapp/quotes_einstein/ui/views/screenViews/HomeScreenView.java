package com.stcodesapp.quotes_einstein.ui.views.screenViews;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.ui.views.baseScreens.BaseObservableScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screens.HomeScreen;

public class HomeScreenView extends BaseObservableScreenView<HomeScreen.Listener> implements HomeScreen{


    public HomeScreenView(LayoutInflater layoutInflater, @Nullable ViewGroup parent)
    {
        setRootView(layoutInflater.inflate(R.layout.home_screen,parent,false));
        inflateUIElements();
        initUserInteractions();
    }


    @Override
    public void inflateUIElements() {

    }

    @Override
    public void initUserInteractions() {

    }




}
