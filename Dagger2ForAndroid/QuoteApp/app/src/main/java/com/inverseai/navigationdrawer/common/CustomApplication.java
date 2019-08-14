package com.inverseai.navigationdrawer.common;

import android.app.Application;

import com.inverseai.navigationdrawer.common.dependencyInjection.CompositionRoot;

public class CustomApplication extends Application {

    private CompositionRoot compositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        compositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }
}
