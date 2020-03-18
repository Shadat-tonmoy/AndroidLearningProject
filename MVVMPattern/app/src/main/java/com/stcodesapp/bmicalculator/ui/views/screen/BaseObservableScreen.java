package com.stcodesapp.bmicalculator.ui.views.screen;

public interface BaseObservableScreen<ListenerType> extends BaseScreen
{
    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);

}
