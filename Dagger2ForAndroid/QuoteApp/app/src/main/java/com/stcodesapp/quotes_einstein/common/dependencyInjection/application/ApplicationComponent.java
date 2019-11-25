package com.stcodesapp.quotes_einstein.common.dependencyInjection.application;

import com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation.PresentationComponent;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation.PresentationModule;
import com.stcodesapp.quotes_einstein.database.AppDatabase;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent
{

    /**
     * This explicit exposure is not required as Presentation Component is the sub component of
     * Application Component.
     * */
    /*AppDatabase getAppDatabase();*/

    PresentationComponent newPresentationComponent(PresentationModule presentationModule);
}
