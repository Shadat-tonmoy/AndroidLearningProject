package com.stcodesapp.bmicalculator.common.baseUI;

import androidx.fragment.app.Fragment;

import com.stcodesapp.bmicalculator.common.BMICalculatorApp;
import com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.PresentationComponent;
import com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.modules.PresentationModule;

public class BaseFragment extends Fragment
{
    PresentationComponent presentationComponent;

    public PresentationComponent getPresentationComponent()
    {
        return ((BMICalculatorApp) requireActivity().getApplication())
                .getApplicationComponent()
                .getPresentationComponent(new PresentationModule(requireActivity()));
    }
}
