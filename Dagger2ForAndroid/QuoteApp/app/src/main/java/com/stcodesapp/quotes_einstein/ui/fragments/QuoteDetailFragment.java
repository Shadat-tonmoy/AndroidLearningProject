package com.stcodesapp.quotes_einstein.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stcodesapp.quotes_einstein.constants.Tags;
import com.stcodesapp.quotes_einstein.controllers.fragmentController.QuoteDetailController;
import com.stcodesapp.quotes_einstein.models.Quotes;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.fragmentScreenView.QuoteDetailScreenView;

public class QuoteDetailFragment extends BaseFragment
{

    private QuoteDetailScreenView quoteDetailScreenView;
    private QuoteDetailController quoteDetailController;
    private Quotes quotes;

    public static QuoteDetailFragment newInstance(Bundle args)
    {
        QuoteDetailFragment fragment = new QuoteDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        quoteDetailScreenView = getCompositionRoot().getViewFactory().getQuoteDetailScreenView(container);
        quoteDetailController = getCompositionRoot().getControllerFactory().getQuoteDetailController();
        getQuotes();
        quoteDetailController.bindView(quoteDetailScreenView);
        quoteDetailController.bindQuotes(quotes);
        return quoteDetailScreenView.getRootView();
    }

    private void getQuotes()
    {
        Bundle args = getArguments();
        if(args!=null)
        {
            quotes = (Quotes) getArguments().getSerializable(Tags.QUOTES_BUNDLE_KEY);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        quoteDetailController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        quoteDetailController.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
