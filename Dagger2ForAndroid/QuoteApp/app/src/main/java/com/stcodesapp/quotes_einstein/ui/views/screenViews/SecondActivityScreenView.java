package com.stcodesapp.quotes_einstein.ui.views.screenViews;

import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.ui.views.baseScreens.BaseObservableScreenView;
import com.stcodesapp.quotes_einstein.ui.views.screens.activityScreen.SecondActivityScreen;


public class SecondActivityScreenView extends BaseObservableScreenView<SecondActivityScreen.Listener> implements SecondActivityScreen {


    private Toolbar toolbar;


    public SecondActivityScreenView(LayoutInflater inflater, @Nullable ViewGroup parent)
    {
        setRootView(inflater.inflate(R.layout.second_activity_screen,parent,false));
        inflateUIElements();
    }




    @Override
    public void initUserInteractions()
    {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Listener listener:getListeners())
                {
                    listener.onNavigateUp();
                }
            }
        });


    }

    @Override
    public void inflateUIElements() {

        toolbar = findViewById(R.id.app_toolbar);
        toolbar.setTitle(getContext().getResources().getString(R.string.second_activity));
        toolbar.setNavigationIcon(getContext().getResources().getDrawable(R.drawable.back_white));


    }

    public Toolbar getToolbar() {
        return toolbar;
    }
}
