package com.stcodesapp.quotes_einstein.tasks.utilityTasks;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.constants.Constants;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

public class ClipboardTasks {
    private Context context;

    public ClipboardTasks(Context context)
    {
        this.context = context;
    }

    public String getPasteData()
    {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        String pasteData = "";
        if(hasPasteText())
        {
            ClipData.Item item;
            if(clipboard.getPrimaryClip()!=null)
            {
                item = clipboard.getPrimaryClip().getItemAt(0);
                return item.getText().toString();
            }
            else return Constants.EMPTY_STRING;
        }
        return Constants.EMPTY_STRING;
    }

    public boolean hasPasteText()
    {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        return clipboard != null && clipboard.hasPrimaryClip() && (clipboard.getPrimaryClipDescription() != null && clipboard.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN));
    }

    public void hideKeyBoard()
    {
        Log.e("Keyboard","Hiding");
        InputMethodManager inputManager = (InputMethodManager)context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        View focusedView = ((Activity)context).getCurrentFocus();
        if (focusedView == null)
        {
            Log.e("FocusedView","Null");

            return;
        }
        inputManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        Log.e("Keyboard","Hidden");
    }

    public void hideKeyBoard(EditText editText)
    {
        Log.e("Keyboard","Hiding");
        InputMethodManager inputManager = (InputMethodManager)context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        Log.e("Keyboard","Hidden");
    }

    public void showKeyBoard()
    {
        InputMethodManager inputMethodManager = (InputMethodManager) ((Activity)context).getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void copyToClipboard(String text)
    {
        ClipboardManager clipboard = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(context.getPackageName(), text);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(context, context.getResources().getText(R.string.text_copied), Toast.LENGTH_SHORT).show();
    }
}
