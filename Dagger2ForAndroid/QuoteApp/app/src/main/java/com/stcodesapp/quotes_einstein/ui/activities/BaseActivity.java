package com.stcodesapp.quotes_einstein.ui.activities;

import android.support.v7.app.AppCompatActivity;

import com.stcodesapp.quotes_einstein.common.CustomApplication;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.application.ApplicationComponent;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation.PresentationComponent;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation.PresentationModule;

public class BaseActivity extends AppCompatActivity {

    private PresentationComponent presentationComponent;

    public PresentationComponent getPresentationComponent() {
        if(presentationComponent==null)
        {
            //this is not valid when use presentation component as a sub component
            /*presentationComponent= DaggerPresentationComponent
                    .builder()
                    .presentationModule(new PresentationModule(this))
                    .applicationComponent(getApplicationComponent())
                    .build();*/
            presentationComponent = getApplicationComponent()
                    .newPresentationComponent(new PresentationModule(this));
        }
        return presentationComponent;
    }

    public ApplicationComponent getApplicationComponent()
    {
        return ((CustomApplication)getApplication()).getApplicationComponent();
    }
}
