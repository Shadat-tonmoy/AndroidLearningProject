package com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.modules;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;

import com.stcodesapp.bmicalculator.factory.ViewFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule
{
    private FragmentActivity fragmentActivity;

    public PresentationModule(FragmentActivity fragmentActivity)
    {
        this.fragmentActivity = fragmentActivity;
    }

    @Provides
    Activity getActivity()
    {
        return fragmentActivity;
    }

    @Provides
    Context getContext()
    {
        return fragmentActivity;
    }

    @Provides
    LayoutInflater getLayoutInflater(Activity activity)
    {
        return activity.getLayoutInflater();
    }

    @Provides
    ViewFactory getViewFactory(LayoutInflater layoutInflater)
    {
        return new ViewFactory(layoutInflater);
    }


}
