package com.stcodesapp.quotes_einstein.factory;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.stcodesapp.quotes_einstein.ui.commons.NavigationDrawerView;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.HomeScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.SecondActivityScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.fragmentScreenView.NavigationMenu1FragmentScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.fragmentScreenView.NavigationMenu2FragmentScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.fragmentScreenView.QuoteDetailScreenView;

public class ViewFactory {

    private final LayoutInflater layoutInflater;
    private final AdapterFactory adapterFactory;

    public ViewFactory(LayoutInflater layoutInflater, AdapterFactory adapterFactory) {
        this.layoutInflater = layoutInflater;
        this.adapterFactory = adapterFactory;
    }


    public NavigationDrawerView getNavigationDrawerView(ViewGroup parent)
    {
        return new NavigationDrawerView(layoutInflater,parent);
    }

    public HomeScreenView getHomeScreenView(ViewGroup parent)
    {
        return new HomeScreenView(layoutInflater,parent,adapterFactory.getQuoteListAdapter());
    }

    public QuoteDetailScreenView getQuoteDetailScreenView(ViewGroup parent)
    {
        return new QuoteDetailScreenView(layoutInflater, parent);
    }

    public SecondActivityScreenView getSecondaryScreenView(ViewGroup parent)
    {
        return new SecondActivityScreenView(layoutInflater,parent);
    }

    public NavigationMenu1FragmentScreenView getNavigationMenu1Screen(ViewGroup parent)
    {
        return new NavigationMenu1FragmentScreenView(layoutInflater,parent);
    }

    public NavigationMenu2FragmentScreenView getNavigationMenu2FragmentScreenView(ViewGroup parent)
    {
        return new NavigationMenu2FragmentScreenView(layoutInflater,parent);
    }
}
