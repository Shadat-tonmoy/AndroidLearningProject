package com.stcodesapp.quotes_einstein.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.fragmentScreenView.NavigationMenu1FragmentScreenView;

import javax.inject.Inject;

public class NavigationMenu1Fragment extends BaseFragment {

    @Inject ViewFactory viewFactory;
    @Inject ControllerFactory controllerFactory;

    private NavigationMenu1FragmentScreenView navigationMenu1FragmentScreenView;

    public static NavigationMenu1Fragment newInstance()
    {
        Bundle args = new Bundle();
        NavigationMenu1Fragment navigationMenu1Fragment = new NavigationMenu1Fragment();
        navigationMenu1Fragment.setArguments(args);
        return navigationMenu1Fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getPresentationComponent().inject(this);
        navigationMenu1FragmentScreenView = viewFactory.getNavigationMenu1Screen(null);
        setHasOptionsMenu(true);
        return navigationMenu1FragmentScreenView.getRootView();
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.home_popup_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return true;
    }
}
