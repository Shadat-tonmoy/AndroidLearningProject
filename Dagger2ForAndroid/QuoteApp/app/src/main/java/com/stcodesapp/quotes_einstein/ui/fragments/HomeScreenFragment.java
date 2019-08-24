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
import com.stcodesapp.quotes_einstein.controllers.fragmentController.HomeScreenController;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.HomeScreenView;

import javax.inject.Inject;

public class HomeScreenFragment extends BaseFragment {


    @Inject ViewFactory viewFactory;
    @Inject ControllerFactory controllerFactory;


    private HomeScreenView homeScreenView;
    private HomeScreenController homeScreenController;


    public static HomeScreenFragment newInstance()
    {
        Bundle args = new Bundle();
        HomeScreenFragment homeScreenFragment = new HomeScreenFragment();
        homeScreenFragment.setArguments(args);
        return homeScreenFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initComponents();
        return homeScreenView.getRootView();
    }

    private void initComponents()
    {
        getPresentationComponent().inject(this);
        homeScreenView = viewFactory.getHomeScreenView(null);
        homeScreenController = controllerFactory.getHomeScreenController();
        homeScreenView.setQuoteListLstener(homeScreenController);
        homeScreenController.bindView(homeScreenView);
        setHasOptionsMenu(true);
    }


    @Override
    public void onStart() {
        super.onStart();
        homeScreenController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        homeScreenController.onStop();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_popup_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        homeScreenController.onOptionMenuClicked(item.getItemId());
        return true;
    }


}
