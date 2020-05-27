package com.shadattonmoy.androidJetPackDemo.useCase;

import android.os.AsyncTask;

import com.shadattonmoy.androidJetPackDemo.dataSource.DummyDataSource;
import com.shadattonmoy.androidJetPackDemo.models.Person;

public class PersonInfoFetchUseCase extends AsyncTask<Void,Void,Void>
{

    public interface Listener
    {
        void onPersonInfoFetchSuccess(Person person);
        void onPersonInfoFetchFailure();
    }

    private Listener listener;

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids)
    {
        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);
        if(listener!=null)
        {
            listener.onPersonInfoFetchSuccess(DummyDataSource.getUpdatedPerson());
        }
    }

    public void setListener(Listener listener)
    {
        this.listener = listener;
    }
}
