package com.stcodesapp.bmicalculator.common.dependencyInjection.application;

import com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.PresentationComponent;
import com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.modules.PresentationModule;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent
{
    PresentationComponent getPresentationComponent(PresentationModule presentationModule);

}
