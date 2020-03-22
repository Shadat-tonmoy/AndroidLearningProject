package com.stcodesapp.bmicalculator.common;

import androidx.appcompat.app.AppCompatActivity;

import com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.PresentationComponent;
import com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.modules.PresentationModule;

public class BaseActivity extends AppCompatActivity
{
    PresentationComponent presentationComponent;

    public PresentationComponent getPresentationComponent()
    {
        return ((BMICalculatorApp)getApplication())
                .getApplicationComponent()
                .getPresentationComponent(new PresentationModule(this));
    }
}
