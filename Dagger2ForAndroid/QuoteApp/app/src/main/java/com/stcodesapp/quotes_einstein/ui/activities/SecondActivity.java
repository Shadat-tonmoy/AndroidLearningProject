package com.stcodesapp.quotes_einstein.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.stcodesapp.quotes_einstein.controllers.activityController.SecondActivityController;
import com.stcodesapp.quotes_einstein.controllers.commons.FragmentFrameWrapper;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.SecondActivityScreenView;

import javax.inject.Inject;

public class SecondActivity extends BaseActivity implements FragmentFrameWrapper {


    @Inject ViewFactory viewFactory;
    @Inject ControllerFactory controllerFactory;


    private SecondActivityScreenView secondActivityScreenView;
    private SecondActivityController secondActivityController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init()
    {
        getPresentationComponent().inject(this);
        secondActivityScreenView = viewFactory.getSecondaryScreenView(null);
        secondActivityController = controllerFactory.getSecondActivityController();
        secondActivityController.bindView(secondActivityScreenView);
        setContentView(secondActivityScreenView.getRootView());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setSupportActionBar(secondActivityScreenView.getToolbar());
        secondActivityController.onPostCreate();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onStart() {
        super.onStart();
        secondActivityController.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        secondActivityController.onStop();
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return null;
    }
}
