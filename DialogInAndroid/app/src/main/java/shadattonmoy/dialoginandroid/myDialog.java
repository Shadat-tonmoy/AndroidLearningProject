package shadattonmoy.dialoginandroid;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Shadat Tonmoy on 6/2/2017.
 */

public class myDialog extends DialogFragment implements View.OnClickListener{
    Button yes,no;
    Communicator communicator;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        setCancelable(false);
        View view = inflater.inflate(R.layout.mydialog,null);
        yes = (Button) view.findViewById(R.id.yes);
        no = (Button) view.findViewById(R.id.no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator = (Communicator)getActivity();

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.yes)
        {
            //Toast.makeText(getActivity(),"Yes Button Was Clicked",Toast.LENGTH_SHORT).show();
            communicator.respond("Yes Button Was Clicked");
            dismiss();
        }
        else if(v.getId()==R.id.no)
        {
            //Toast.makeText(getActivity(),"No Button was clicked",Toast.LENGTH_SHORT).show();
            communicator.respond("No Button Was Clicked");
            dismiss();
        }
    }

    interface Communicator{
        public void respond(String data);
    }
}
