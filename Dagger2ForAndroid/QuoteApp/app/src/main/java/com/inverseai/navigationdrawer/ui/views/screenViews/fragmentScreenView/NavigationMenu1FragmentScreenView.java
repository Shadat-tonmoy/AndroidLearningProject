package com.inverseai.navigationdrawer.ui.views.screenViews.fragmentScreenView;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.inverseai.navigationdrawer.R;
import com.inverseai.navigationdrawer.ui.views.baseScreens.BaseObservableScreenView;
import com.inverseai.navigationdrawer.ui.views.screens.fragmentScreen.NavigationMenu1FragmentScreen;

public class NavigationMenu1FragmentScreenView extends BaseObservableScreenView<NavigationMenu1FragmentScreen.Listener> implements NavigationMenu1FragmentScreen {


    public NavigationMenu1FragmentScreenView(LayoutInflater layoutInflater, @Nullable ViewGroup parent)
    {
        setRootView(layoutInflater.inflate(R.layout.navigation_menu_1_screen,parent,false));
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
