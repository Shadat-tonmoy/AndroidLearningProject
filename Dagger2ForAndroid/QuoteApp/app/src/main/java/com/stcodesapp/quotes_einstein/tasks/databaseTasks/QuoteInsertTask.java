package com.stcodesapp.quotes_einstein.tasks.databaseTasks;

import android.app.Activity;
import android.os.AsyncTask;

import com.stcodesapp.quotes_einstein.common.Logger;
import com.stcodesapp.quotes_einstein.database.AppDatabase;
import com.stcodesapp.quotes_einstein.models.Quotes;

import java.util.Arrays;
import java.util.List;

public class QuoteInsertTask extends AsyncTask<List<Quotes>, Void, Void>
{
    private Activity activity;
    private AppDatabase appDatabase;

    public QuoteInsertTask(Activity activity) {
        this.activity = activity;
        this.appDatabase = AppDatabase.getInstance(activity);
    }




    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(List<Quotes>... lists)
    {
        List<Quotes> quotes = lists[0];
        Quotes[] quotesArray = quotes.toArray(new Quotes[0]);
        appDatabase.quoteDao().insertQuote(quotesArray);
        Logger.showLog("Insertion","Done Bro");
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


    }

}
