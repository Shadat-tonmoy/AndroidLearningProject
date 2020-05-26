package com.shadattonmoy.androidJetPackDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.shadattonmoy.androidJetPackDemo.dataSource.DummyDataSource;
import com.shadattonmoy.androidJetPackDemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    MainActivityClickListener clickListener;
    ActivityMainBinding dataBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        initDataBinder();
    }

    private void initDataBinder()
    {
        dataBinder = DataBindingUtil.inflate(getLayoutInflater(),R.layout.activity_main,null,false);
        dataBinder.setPerson(DummyDataSource.getDummyPerson());
        clickListener = new MainActivityClickListener();
        dataBinder.setClickListener(clickListener);
        setContentView(dataBinder.getRoot());
    }

    public class MainActivityClickListener
    {
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


    }
}
