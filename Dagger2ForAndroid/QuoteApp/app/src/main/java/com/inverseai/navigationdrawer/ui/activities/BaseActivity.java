package com.inverseai.navigationdrawer.ui.activities;

import android.support.v7.app.AppCompatActivity;

import com.inverseai.navigationdrawer.common.CustomApplication;
import com.inverseai.navigationdrawer.common.dependencyInjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot controllerCompositionRoot;

    public ControllerCompositionRoot getCompositionRoot() {
        if(controllerCompositionRoot ==null)
        {
            controllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication) getApplication()).getCompositionRoot(),this);
        }
        return controllerCompositionRoot;
    }
}
