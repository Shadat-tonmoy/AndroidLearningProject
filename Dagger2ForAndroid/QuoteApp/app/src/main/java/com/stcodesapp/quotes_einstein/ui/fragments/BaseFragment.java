package com.stcodesapp.quotes_einstein.ui.fragments;

import android.support.v4.app.Fragment;

import com.stcodesapp.quotes_einstein.common.CustomApplication;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.application.ApplicationComponent;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation.DaggerPresentationComponent;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation.PresentationComponent;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation.PresentationModule;

public class BaseFragment extends Fragment
{
    private PresentationComponent presentationComponent;

    public PresentationComponent getPresentationComponent()
    {
        if(presentationComponent==null)
        {
            presentationComponent = DaggerPresentationComponent
                    .builder()
                    .presentationModule(new PresentationModule(requireActivity()))
                    .applicationComponent(getApplicationComponent())
                    .build();
        }
        return presentationComponent;
    }

    private ApplicationComponent getApplicationComponent()
    {
        return ((CustomApplication)requireActivity().getApplication()).getApplicationComponent();
    }


}
