package com.stcodesapp.bmicalculator.ui.views.screenViews;

import com.stcodesapp.bmicalculator.ui.views.screen.BaseObservableScreen;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableScreenView<ListenerType> implements BaseObservableScreen<ListenerType>
{
    private Set<ListenerType> listeners = new HashSet<>();

    @Override
    public void registerListener(ListenerType listener)
    {
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(ListenerType listener)
    {
        listeners.remove(listener);
    }

    public Set<ListenerType> getListeners()
    {
        return Collections.unmodifiableSet(listeners);
    }
}
