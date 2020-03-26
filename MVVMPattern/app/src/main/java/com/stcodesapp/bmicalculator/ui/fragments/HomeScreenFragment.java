package com.stcodesapp.bmicalculator.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.stcodesapp.bmicalculator.common.baseUI.BaseFragment;
import com.stcodesapp.bmicalculator.controller.activityController.MainActivityController;
import com.stcodesapp.bmicalculator.factory.ViewFactory;
import com.stcodesapp.bmicalculator.ui.views.screenView.activityScreenViews.MainActivityScreenView;

import javax.inject.Inject;

public class HomeScreenFragment extends BaseFragment
{
    @Inject ViewFactory viewFactory;
    @Inject MainActivityController controller;
    private MainActivityScreenView screenView;

    public static HomeScreenFragment newInstance()
    {
        Bundle args = new Bundle();
        HomeScreenFragment fragment = new HomeScreenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        init(container);
        return screenView.getRootView();
    }

    private void init(ViewGroup container)
    {
        getPresentationComponent().inject(this);
        screenView = viewFactory.getMainActivityScreenView(container);
        controller.bindView(screenView);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
