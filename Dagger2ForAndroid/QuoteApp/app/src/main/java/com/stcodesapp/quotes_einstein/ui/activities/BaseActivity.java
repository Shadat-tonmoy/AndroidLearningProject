package com.stcodesapp.quotes_einstein.ui.activities;

import android.support.v7.app.AppCompatActivity;

import com.stcodesapp.quotes_einstein.common.CustomApplication;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.ActivityCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ActivityCompositionRoot compositionRoot;

    public ActivityCompositionRoot getCompositionRoot() {
        if(compositionRoot ==null)
        {
            compositionRoot = new ActivityCompositionRoot(
                    ((CustomApplication) getApplication()).getCompositionRoot(),
                    this, getSupportFragmentManager());
        }
        return compositionRoot;
    }
}
