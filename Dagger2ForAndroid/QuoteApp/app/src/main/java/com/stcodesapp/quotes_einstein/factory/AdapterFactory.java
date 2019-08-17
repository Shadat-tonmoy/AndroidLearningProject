package com.stcodesapp.quotes_einstein.factory;

import android.app.Activity;

import com.stcodesapp.quotes_einstein.ui.adapter.QuoteListAdapter;

public class AdapterFactory
{
    private Activity activity;

    public AdapterFactory(Activity activity)
    {
        this.activity = activity;
    }

    public QuoteListAdapter getQuoteListAdapter()
    {
        return new QuoteListAdapter(activity);
    }


}
