package com.stcodesapp.bmicalculator.ui.views.screenView.activityScreenViews;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.stcodesapp.bmicalculator.R;
import com.stcodesapp.bmicalculator.ui.views.screen.activityScreen.MainActivityScreen;
import com.stcodesapp.bmicalculator.ui.views.screenView.commons.BaseObservableScreenView;

public class MainActivityScreenView extends BaseObservableScreenView<MainActivityScreen.Listener> implements MainActivityScreen
{

    private static final String TAG = "MainActivityScreenView";
    private TextView randomNumberView;
    private Button generateRandomNumberButton;


    public MainActivityScreenView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup parent)
    {
        setRootView(layoutInflater.inflate(R.layout.main_activity_layout,parent,false));
        inflateUIElements();
        initUserInteractions();
    }

    @Override
    public void inflateUIElements()
    {
        randomNumberView = findViewById(R.id.random_number_output);
        generateRandomNumberButton = findViewById(R.id.generate_random_number_button);

    }

    @Override
    public void initUserInteractions()
    {
        generateRandomNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Log.e(TAG, "onClick: NotifyingListeners" + getListeners().size());
                for(MainActivityScreen.Listener listener : getListeners())
                {
                    Log.e(TAG, "onClick: NotifyingListeners" + listener);
                    listener.onGenerateRandomNumberButtonClicked();
                }
            }
        });
    }

    public TextView getRandomNumberView() {
        return randomNumberView;
    }

    public Button getGenerateRandomNumberButton() {
        return generateRandomNumberButton;
    }
}
