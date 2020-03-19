package com.stcodesapp.common.dependencyInjection.application;

import com.stcodesapp.common.dependencyInjection.presentation.PresentationComponent;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent
{
    PresentationComponent getPresentationComponent();

}
