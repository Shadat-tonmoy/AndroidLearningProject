package com.stcodesapp.quotes_einstein.common.dependencyInjection;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import com.stcodesapp.quotes_einstein.common.FragmentFrameHelper;
import com.stcodesapp.quotes_einstein.controllers.commons.FragmentFrameWrapper;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;

public class ControllerCompositionRoot {

    private CompositionRoot compositionRoot;
    private FragmentActivity activity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity) {
        this.compositionRoot = compositionRoot;
        this.activity = activity;
    }

    private FragmentActivity getActivity() {
        return activity;
    }

    private Context getContext()
    {
        return activity;
    }

    private LayoutInflater getLayoutInflater()
    {
        return LayoutInflater.from(getContext());
    }

    public ViewFactory getViewFactory()
    {
        return compositionRoot.getViewFactory(getLayoutInflater());
    }

    public ControllerFactory getActivityControllerFactory()
    {
        return compositionRoot.getActivityControllerFactory(getActivity());
    }

    public ControllerFactory getFragmentControllerFactory()
    {
        return compositionRoot.getFragmentControllerFactory(getActivity(),getFragmentFrameHelper());
    }

    public TasksFactory getActivityTasksFactory()
    {
        return compositionRoot.getTasksFactory(getActivity());
    }

    public TasksFactory getFragmentTasksFactory()
    {
        return compositionRoot.getTasksFactory(getActivity(),getFragmentFrameHelper());
    }

    public FragmentManager getFragmentManager()
    {
        return getActivity().getSupportFragmentManager();
    }

    private FragmentFrameWrapper getFragmentFrameWrapper()
    {
        return (FragmentFrameWrapper) getActivity();
    }

    public FragmentFrameHelper getFragmentFrameHelper()
    {
        return new FragmentFrameHelper(getActivity(),getFragmentFrameWrapper(),getFragmentManager());
    }









}
