package com.shadattonmoy.androidJetPackDemo.uiController;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;

import com.shadattonmoy.androidJetPackDemo.R;
import com.shadattonmoy.androidJetPackDemo.dataSource.DummyDataSource;
import com.shadattonmoy.androidJetPackDemo.databinding.ActivityMainBinding;
import com.shadattonmoy.androidJetPackDemo.helpers.DialogHelper;
import com.shadattonmoy.androidJetPackDemo.models.Person;
import com.shadattonmoy.androidJetPackDemo.viewModels.PersonViewModel;

public class MainActivityController implements LifecycleObserver
{
    private static final String TAG = "MainActivityController";

    private AppCompatActivity activity;
    private ActivityMainBinding dataBinder;
    private PersonViewModel personViewModel;

    public MainActivityController(AppCompatActivity activity)
    {
        this.activity = activity;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate()
    {
        Log.e(TAG, "onCreate: FromUIController");
        initDataBinder();
        initViewModel();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart()
    {
        Log.e(TAG, "onStart: FromUIController");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop()
    {
        Log.e(TAG, "onStop: FromUIController");
    }

    private void initDataBinder()
    {
        dataBinder = DataBindingUtil.setContentView(activity, R.layout.activity_main);
        dataBinder.setPerson(DummyDataSource.getDummyPerson());
        dataBinder.setClickListener(this);
        activity.setContentView(dataBinder.getRoot());
    }

    private void initViewModel()
    {
        personViewModel = new ViewModelProvider(activity).get(PersonViewModel.class);
        personViewModel.getPerson().observe(activity, new Observer<Person>() {
            @Override
            public void onChanged(Person person)
            {
                dataBinder.setPerson(person);
            }
        });

    }

    public void onEmailButtonClicked(View view)
    {
        Toast.makeText(view.getContext(), "ClickedOnEmail", Toast.LENGTH_SHORT).show();

    }

    public void onPhoneButtonClicked(View view)
    {
        Toast.makeText(view.getContext(), "ClickedOnPhone", Toast.LENGTH_SHORT).show();
    }

    public void onMessageButtonClicked(View view)
    {
        Toast.makeText(view.getContext(), "ClickedOnMessage", Toast.LENGTH_SHORT).show();
    }

    public void onUpdateDataClicked(View view)
    {
        DialogHelper.showProgressDialog(activity,activity.getString(R.string.updating_info));
        personViewModel.updatePersonInfo();
    }




}
