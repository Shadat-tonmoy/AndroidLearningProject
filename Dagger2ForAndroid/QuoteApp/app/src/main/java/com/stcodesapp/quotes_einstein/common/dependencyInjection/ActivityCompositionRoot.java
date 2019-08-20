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
import com.stcodesapp.quotes_einstein.ui.dialog.DialogManager;

public class ActivityCompositionRoot {

    private CompositionRoot compositionRoot;
    private FragmentActivity activity;
    private FragmentManager fragmentManager;

    public ActivityCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity, FragmentManager fragmentManager) {
        this.compositionRoot = compositionRoot;
        this.activity = activity;
        this.fragmentManager = fragmentManager;
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
        return compositionRoot.getViewFactory(getLayoutInflater(),activity);
    }

    public ControllerFactory getControllerFactory()
    {
        return compositionRoot.getControllerFactory(getActivity(),getFragmentFrameHelper());
    }

    public TasksFactory getTasksFactory()
    {
        return compositionRoot.getTasksFactory(getActivity());
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

    public DialogManager getDialogManager()
    {
        return new DialogManager(fragmentManager,activity);
    }









}
