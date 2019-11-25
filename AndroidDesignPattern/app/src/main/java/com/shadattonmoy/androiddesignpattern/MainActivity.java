package com.shadattonmoy.androiddesignpattern;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.shadattonmoy.androiddesignpattern.basicMVC.BasicMVC;

//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.simple_mvc)
    Button simpleMVCButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleMVCButton = findViewById(R.id.simple_mvc);
        simpleMVCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMVCActivity();
            }
        });
//        ButterKnife.bind(this);
    }

//    @OnClick(R.id.simple_mvc)
    private void startMVCActivity()
    {
        Intent intent = new Intent(this, BasicMVC.class);
        startActivity(intent);
    }
}
