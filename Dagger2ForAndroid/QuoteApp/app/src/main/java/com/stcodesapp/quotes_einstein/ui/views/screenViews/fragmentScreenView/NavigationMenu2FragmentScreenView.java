package com.stcodesapp.quotes_einstein.ui.views.screenViews.fragmentScreenView;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.ui.views.baseScreens.BaseObservableScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screens.fragmentScreen.NavigationMenu1FragmentScreen;

public class NavigationMenu2FragmentScreenView extends BaseObservableScreenView<NavigationMenu1FragmentScreen.Listener> implements NavigationMenu1FragmentScreen {


    public NavigationMenu2FragmentScreenView(LayoutInflater layoutInflater, @Nullable ViewGroup parent)
    {
        setRootView(layoutInflater.inflate(R.layout.navigation_menu_2_screen,parent,false));
        inflateUIElements();
        initUserInteractions();
    }

    @Override
    public void initUserInteractions() {

    }

    @Override
    public void inflateUIElements() {

    }
}
