package com.stcodesapp.quotes_einstein.tasks.databaseTasks;

import android.app.Activity;
import android.os.AsyncTask;

import com.stcodesapp.quotes_einstein.common.Logger;
import com.stcodesapp.quotes_einstein.database.AppDatabase;
import com.stcodesapp.quotes_einstein.models.Quotes;

import java.util.List;

public class QuoteFetchingTask extends AsyncTask<Void, Void, List<Quotes>>
{

    public interface Listener
    {
        void onQuoteListFetched(List<Quotes> quotes);

    }

    private Activity activity;
    private AppDatabase appDatabase;
    private Listener listener;

    public QuoteFetchingTask(Activity activity) {
        this.activity = activity;
        this.appDatabase = AppDatabase.getInstance(activity);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Quotes> doInBackground(Void... voids)
    {

        return appDatabase.quoteDao().getAllQuotes();
    }

    @Override
    protected void onPostExecute(List<Quotes> quotes) {
        super.onPostExecute(quotes);
        if(listener!=null)
            listener.onQuoteListFetched(quotes);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
