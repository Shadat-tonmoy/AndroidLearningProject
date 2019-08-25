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
import dagger.Subcomponent;

/**
 * The dependencies argument enlisted the dependencies of Presentation Component. Currently presentation
 * component has only one dependency, Namely Application Component
 * */
//@Component(modules = PresentationModule.class, dependencies = ApplicationComponent.class)

/**
 * Declaring inter component dependencies can be made more tight and easy by using sub component.
 * Here, Presentation Component is a sub component of Application Component. That is Application Component
 * is the parent and Presentation Component is the child. This parent child relation is established by
 * simply providing a factory method with the module as argument of the factory inside parent component.
 * Using this approach, Child component automatically gets all the provides method (no need to be exposed
 * from component, providing from module is enough) from the parent component
 * */
@Subcomponent(modules = PresentationModule.class)
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
