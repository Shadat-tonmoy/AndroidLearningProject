package com.stcodesapp.quotes_einstein.common.dependencyInjection.application;


import com.stcodesapp.quotes_einstein.common.CustomApplication;
import com.stcodesapp.quotes_einstein.database.AppDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule
{

    private CustomApplication application;

    public ApplicationModule(CustomApplication application) {
        this.application= application;
    }

    //these dependencies resides inside application lifecycle
    @Provides
    AppDatabase getAppDatabase()
    {
        return AppDatabase.getInstance(getApplication());
    }

    @Provides
    CustomApplication getApplication()
    {
        return application;
    }
}
