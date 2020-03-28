package com.stcodesapp.bmicalculator.ui.activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.stcodesapp.bmicalculator.common.baseUI.BaseActivity;
import com.stcodesapp.bmicalculator.common.fragmentHelper.FragmentFrameWrapper;
import com.stcodesapp.bmicalculator.controller.activityController.BottomNavigationController;
import com.stcodesapp.bmicalculator.factory.ViewFactory;
import com.stcodesapp.bmicalculator.ui.views.screenView.commons.BottomNavigationScreenView;

import javax.inject.Inject;

public class BaseBottomNavigationActivity extends BaseActivity implements FragmentFrameWrapper {


    @Inject BottomNavigationController controller;
    @Inject ViewFactory viewFactory;
    private BottomNavigationScreenView screenView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNavigationDrawerLayout();
    }

    private void initNavigationDrawerLayout()
    {
        getPresentationComponent().inject(this);
        screenView = viewFactory.getBottomNavigationScreenView(null);
        controller.bindView(screenView);
        setActionBar();
        setContentView(screenView.getRootView());

    }

    private void setActionBar()
    {
        setSupportActionBar(screenView.getToolbar());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        controller.onPostCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        controller.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        controller.onStop();
    }

    @Override
    public void onBackPressed()
    {
        controller.onBackPressed();
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return screenView.getFrameLayout();
    }
}
