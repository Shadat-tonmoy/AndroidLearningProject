package com.stcodesapp.common;

import androidx.appcompat.app.AppCompatActivity;

import com.stcodesapp.common.dependencyInjection.presentation.PresentationComponent;

public class BaseActivity extends AppCompatActivity
{
    PresentationComponent presentationComponent;

    public PresentationComponent getPresentationComponent()
    {
        return ((BMICalculatorApp)getApplication()).getApplicationComponent().getPresentationComponent();
    }
}
