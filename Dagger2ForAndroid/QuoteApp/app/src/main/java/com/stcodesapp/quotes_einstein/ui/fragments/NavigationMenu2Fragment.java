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
import com.stcodesapp.quotes_einstein.factory.ViewFactory;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.fragmentScreenView.NavigationMenu2FragmentScreenView;

import javax.inject.Inject;

public class NavigationMenu2Fragment extends BaseFragment {

    @Inject ViewFactory viewFactory;


    private NavigationMenu2FragmentScreenView navigationMenu2FragmentScreenView;

    public static NavigationMenu2Fragment newInstance()
    {
        Bundle args = new Bundle();
        NavigationMenu2Fragment navigationMenu2Fragment = new NavigationMenu2Fragment();
        navigationMenu2Fragment.setArguments(args);
        return navigationMenu2Fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getPresentationComponent().inject(this);
        navigationMenu2FragmentScreenView = viewFactory.getNavigationMenu2FragmentScreenView(null);
        setHasOptionsMenu(true);
        return navigationMenu2FragmentScreenView.getRootView();
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_popup_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }
}
