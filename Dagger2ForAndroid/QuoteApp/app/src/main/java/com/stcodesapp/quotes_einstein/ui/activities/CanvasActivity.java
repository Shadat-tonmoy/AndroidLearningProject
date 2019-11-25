package com.stcodesapp.quotes_einstein.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        final TextWithBackgroundView textWithBackgroundView = findViewById(R.id.custom_view);
        Button changeColorButton = findViewById(R.id.change_color_button);
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textWithBackgroundView.swapColor();
            }
        });

    }
}
