package com.shadattonmoy.androidJetPackDemo.helpers;

import android.app.Activity;
import android.app.ProgressDialog;

public class DialogHelper
{
    private static ProgressDialog progressDialog;

    public static void showProgressDialog(Activity activity, String message)
    {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public static void dismissProgressDialog()
    {
        if(progressDialog!=null && progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
