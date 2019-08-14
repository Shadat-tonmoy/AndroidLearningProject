package com.stcodesapp.quotes_einstein.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.stcodesapp.quotes_einstein.controllers.activityController.SecondActivityController;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.SecondActivityScreenView;

public class SecondActivity extends BaseActivity {


    private SecondActivityScreenView secondActivityScreenView;
    private SecondActivityController secondActivityController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init()
    {
        secondActivityScreenView = getCompositionRoot().getViewFactory().getSecondaryScreenView(null);
        secondActivityController = getCompositionRoot().getActivityControllerFactory().getSecondActivityController();
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
}
