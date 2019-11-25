package shadattonmoy.dialogusingalertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Shadat Tonmoy on 6/2/2017.
 */

public class myDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("My Dialog");
        dialog.setCancelable(false);
        //dialog.setMessage("Do you like this dialog?");
        dialog.setItems(R.array.names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] names = getActivity().getResources().getStringArray(R.array.names);
                Toast.makeText(getActivity(),"You have clicked "+names[which],Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Negative Button was clicked",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Positive button was clicked",Toast.LENGTH_SHORT).show();
            }
        });

        return dialog.create();
    }
}
