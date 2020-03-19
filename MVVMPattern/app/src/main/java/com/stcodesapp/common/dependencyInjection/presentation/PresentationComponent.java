package com.stcodesapp.common.dependencyInjection.presentation;

import com.stcodesapp.common.dependencyInjection.presentation.modules.ControllerModule;
import com.stcodesapp.common.dependencyInjection.presentation.modules.PresentationModule;
import com.stcodesapp.common.dependencyInjection.presentation.modules.TaskModule;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent(modules = {PresentationModule.class, ControllerModule.class, TaskModule.class})
public interface PresentationComponent
{




}
