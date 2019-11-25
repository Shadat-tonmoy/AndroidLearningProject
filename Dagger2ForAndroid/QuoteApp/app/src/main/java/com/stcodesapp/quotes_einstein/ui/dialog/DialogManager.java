package com.stcodesapp.quotes_einstein.ui.dialog;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

public class DialogManager
{

    private FragmentManager fragmentManager;
    private Activity activity;

    public DialogManager(FragmentManager fragmentManager, Activity activity) {
        this.fragmentManager = fragmentManager;
        this.activity = activity;
    }
}
