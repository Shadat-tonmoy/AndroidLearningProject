package com.shadattonmoy.androidJetPackDemo.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shadattonmoy.androidJetPackDemo.models.Person;
import com.shadattonmoy.androidJetPackDemo.useCase.PersonInfoFetchUseCase;

public class PersonViewModel extends ViewModel implements PersonInfoFetchUseCase.Listener
{
    private static final String TAG = "PersonViewModel";
    private MutableLiveData<Person> person;

    public LiveData<Person> getPerson()
    {
        if(person==null)
        {
            person = new MutableLiveData<>();
        }
        return person;
    }

    public void updatePersonInfo()
    {
        PersonInfoFetchUseCase useCase = new PersonInfoFetchUseCase();
        useCase.setListener(this);
        useCase.execute();
    }

    @Override
    public void onPersonInfoFetchSuccess(Person person)
    {
        this.person.setValue(person);
        Log.e(TAG, "onPersonInfoFetchSuccess: UpdatedPerson : " + person.toString());

    }

    @Override
    public void onPersonInfoFetchFailure()
    {

    }
}
