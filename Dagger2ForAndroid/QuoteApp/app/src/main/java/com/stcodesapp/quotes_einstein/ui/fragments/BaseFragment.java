package com.stcodesapp.quotes_einstein.ui.fragments;

import android.support.v4.app.Fragment;

import com.stcodesapp.quotes_einstein.common.CustomApplication;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.application.ApplicationComponent;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation.PresentationComponent;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation.PresentationModule;

public class BaseFragment extends Fragment
{
    private PresentationComponent presentationComponent;

    public PresentationComponent getPresentationComponent()
    {
        if(presentationComponent==null)
        {
            //this is not valid when use presentation component as a sub component
           /* presentationComponent = DaggerPresentationComponent
                    .builder()
                    .presentationModule(new PresentationModule(requireActivity()))
                    .applicationComponent(getApplicationComponent())
                    .build();*/
           presentationComponent = getApplicationComponent()
                   .newPresentationComponent(new PresentationModule(requireActivity()));
        }
        return presentationComponent;
    }

    private ApplicationComponent getApplicationComponent()
    {
        return ((CustomApplication)requireActivity().getApplication()).getApplicationComponent();
    }


}
