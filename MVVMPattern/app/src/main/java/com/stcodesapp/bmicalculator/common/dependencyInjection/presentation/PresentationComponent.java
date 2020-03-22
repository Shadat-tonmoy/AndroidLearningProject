package com.stcodesapp.bmicalculator.common.dependencyInjection.presentation;

import com.stcodesapp.bmicalculator.ui.activities.BaseNavigationDrawerActivity;
import com.stcodesapp.bmicalculator.ui.activities.MainActivity;
import com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.modules.ControllerModule;
import com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.modules.PresentationModule;
import com.stcodesapp.bmicalculator.common.dependencyInjection.presentation.modules.TaskModule;

import dagger.Subcomponent;

@Subcomponent(modules = {PresentationModule.class, ControllerModule.class, TaskModule.class})
public interface PresentationComponent
{

     void inject(MainActivity mainActivity);
     void inject(BaseNavigationDrawerActivity baseNavigationDrawerActivity);
}
