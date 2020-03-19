package com.stcodesapp.common.dependencyInjection.presentation.modules;

import androidx.fragment.app.FragmentActivity;

import dagger.Module;

@Module
public class PresentationModule
{
    private FragmentActivity fragmentActivity;

    public PresentationModule(FragmentActivity fragmentActivity)
    {
        this.fragmentActivity = fragmentActivity;
    }


}
