package com.stcodesapp.quotes_einstein.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.models.TextWithBackgroundView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        init();
    }

    private void init()
    {
        LinearLayout linearLayout = findViewById(R.id.canvas_view);
        linearLayout.addView(new TextWithBackgroundView(this));
    }
}
