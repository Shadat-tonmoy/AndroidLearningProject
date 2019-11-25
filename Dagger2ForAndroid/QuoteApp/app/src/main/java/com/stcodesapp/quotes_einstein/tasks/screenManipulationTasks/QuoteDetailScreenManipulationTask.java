package com.stcodesapp.quotes_einstein.tasks.screenManipulationTasks;

import android.app.Activity;

import com.stcodesapp.quotes_einstein.models.Quotes;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.fragmentScreenView.QuoteDetailScreenView;

public class QuoteDetailScreenManipulationTask
{
    private Activity activity;
    private QuoteDetailScreenView quoteDetailScreenView;

    public QuoteDetailScreenManipulationTask(Activity activity) {
        this.activity = activity;
    }

    public void bindView(QuoteDetailScreenView quoteDetailScreenView)
    {
        this.quoteDetailScreenView = quoteDetailScreenView;
    }

    public void bindQuote(Quotes quotes)
    {
        quoteDetailScreenView.getQuoteText().setText(quotes.getQuoteText());
    }
}
