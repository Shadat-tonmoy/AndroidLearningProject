package com.stcodesapp.quotes_einstein.ui.views.screenViews;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.factory.AdapterFactory;
import com.stcodesapp.quotes_einstein.ui.adapter.QuoteListAdapter;
import com.stcodesapp.quotes_einstein.ui.views.baseScreens.BaseObservableScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screens.HomeScreen;

public class HomeScreenView extends BaseObservableScreenView<HomeScreen.Listener> implements HomeScreen
{

    private RecyclerView quoteList;
    private QuoteListAdapter quoteListAdapter;

    public HomeScreenView(LayoutInflater layoutInflater, @Nullable ViewGroup parent, QuoteListAdapter quoteListAdapter)
    {
        setRootView(layoutInflater.inflate(R.layout.home_screen_layout,parent,false));
        this.quoteListAdapter = quoteListAdapter;
        inflateUIElements();
        initUserInteractions();
    }


    @Override
    public void inflateUIElements()
    {
        quoteList = findViewById(R.id.quote_list);
        quoteList.setLayoutManager(new LinearLayoutManager(getContext()));
        quoteList.setAdapter(quoteListAdapter);

    }

    @Override
    public void initUserInteractions() {

    }

    public RecyclerView getQuoteList() {
        return quoteList;
    }

    public QuoteListAdapter getQuoteListAdapter() {
        return quoteListAdapter;
    }

    public void setQuoteListLstener(QuoteListAdapter.Listener listener)
    {
        quoteListAdapter.setListener(listener);
    }
}
