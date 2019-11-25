package com.stcodesapp.quotes_einstein.controllers.fragmentController;

import android.app.Activity;
import android.content.Intent;

import com.stcodesapp.quotes_einstein.constants.Constants;
import com.stcodesapp.quotes_einstein.constants.Tags;
import com.stcodesapp.quotes_einstein.factory.TasksFactory;
import com.stcodesapp.quotes_einstein.models.Quotes;
import com.stcodesapp.quotes_einstein.tasks.screenManipulationTasks.QuoteDetailScreenManipulationTask;
import com.stcodesapp.quotes_einstein.tasks.utilityTasks.ClipboardTasks;
import com.stcodesapp.quotes_einstein.tasks.utilityTasks.SharingTasks;
import com.stcodesapp.quotes_einstein.ui.activities.CanvasActivity;
import com.stcodesapp.quotes_einstein.ui.views.screenViews.fragmentScreenView.QuoteDetailScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screens.fragmentScreen.QuoteDetailScreen;

public class QuoteDetailController implements QuoteDetailScreen.Listener
{

    private Activity activity;
    private TasksFactory tasksFactory;
    private QuoteDetailScreenView quoteDetailScreenView;
    private QuoteDetailScreenManipulationTask quoteDetailScreenManipulationTask;
    private ClipboardTasks clipboardTasks;
    private SharingTasks sharingTasks;
    private Quotes quotes;

    public QuoteDetailController(Activity activity, TasksFactory tasksFactory) {
        this.activity = activity;
        this.tasksFactory = tasksFactory;
        this.quoteDetailScreenManipulationTask = tasksFactory.getQuoteDetailScreenManipulationTask();
        this.clipboardTasks = tasksFactory.getClipboardTasks();
        this.sharingTasks = tasksFactory.getSharingTasks();
    }

    public void bindView(QuoteDetailScreenView quoteDetailScreenView)
    {
        this.quoteDetailScreenView = quoteDetailScreenView;
        quoteDetailScreenManipulationTask.bindView(quoteDetailScreenView);
    }


    public void bindQuotes(Quotes quotes)
    {
        this.quotes = quotes;
        quoteDetailScreenManipulationTask.bindQuote(quotes);
    }

    public void onStart()
    {
        quoteDetailScreenView.registerListener(this);
    }

    public void onStop()
    {
        quoteDetailScreenView.unregisterListener(this);
    }

    @Override
    public void onCopyQuoteClicked()
    {
        clipboardTasks.copyToClipboard(quotes.getQuoteText());

    }

    @Override
    public void onListenQuoteClicked() {

    }

    @Override
    public void onShareQuoteClicked()
    {
        sharingTasks.shareText(quotes.getQuoteText());

    }

    @Override
    public void onDrawBackgroundButtonClicked()
    {
        Intent intent = new Intent(activity, CanvasActivity.class);
        intent.putExtra(Tags.QUOTE_TEXT,quotes.getQuoteText());
        activity.startActivity(intent);


    }
}
