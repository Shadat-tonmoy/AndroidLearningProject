package com.stcodesapp.quotes_einstein.common.dependencyInjection.presentation;


import com.stcodesapp.quotes_einstein.common.dependencyInjection.application.ApplicationComponent;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;
import com.stcodesapp.quotes_einstein.ui.activities.BaseNavigationDrawerActivity;
import com.stcodesapp.quotes_einstein.ui.activities.MainActivity;
import com.stcodesapp.quotes_einstein.ui.activities.SecondActivity;
import com.stcodesapp.quotes_einstein.ui.fragments.HomeScreenFragment;
import com.stcodesapp.quotes_einstein.ui.fragments.NavigationMenu1Fragment;
import com.stcodesapp.quotes_einstein.ui.fragments.NavigationMenu2Fragment;
import com.stcodesapp.quotes_einstein.ui.fragments.QuoteDetailFragment;

import dagger.Component;

@Component(modules = PresentationModule.class, dependencies = ApplicationComponent.class)
public interface PresentationComponent
{

    void inject(HomeScreenFragment homeScreenFragment);
    void inject(QuoteDetailFragment quoteDetailFragment);
    void inject(NavigationMenu1Fragment navigationMenu1Fragment);
    void inject(NavigationMenu2Fragment navigationMenu2Fragment);
    void inject(BaseNavigationDrawerActivity baseNavigationDrawerActivity);
    void inject(MainActivity mainActivity);
    void inject(SecondActivity secondActivity);



    /*public ViewFactory getViewFactory();
    public ControllerFactory getControllerFactory();
    public TasksFactory getTasksFactory();*/


}
