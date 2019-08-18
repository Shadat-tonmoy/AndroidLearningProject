package com.stcodesapp.quotes_einstein.ui.views.screens.fragmentScreen;

import com.stcodesapp.quotes_einstein.ui.views.baseScreens.BaseObservableScreen;

public interface QuoteDetailScreen extends BaseObservableScreen<QuoteDetailScreen.Listener>
{
    interface Listener
    {
        void onCopyQuoteClicked();

        void onListenQuoteClicked();

        void onShareQuoteClicked();
    }


}
