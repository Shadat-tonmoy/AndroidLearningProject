package com.shadattonmoy.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.shadattonmoy.databindingdemo.dataSource.DummyDataSource;
import com.shadattonmoy.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    ActivityMainBinding dataBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDataBinder();
    }

    private void initDataBinder()
    {
        dataBinder = DataBindingUtil.setContentView(this,R.layout.activity_main);
        dataBinder.setPerson(DummyDataSource.getDummyPerson());
    }
}
