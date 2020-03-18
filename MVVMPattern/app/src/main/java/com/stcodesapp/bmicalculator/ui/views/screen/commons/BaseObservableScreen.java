package com.stcodesapp.bmicalculator.ui.views.screen.commons;

public interface BaseObservableScreen<ListenerType> extends BaseScreen
{
    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);

    void initUserInteractions();

}
