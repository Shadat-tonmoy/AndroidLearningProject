package layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import shadattonmoy.interfragmentcommunication.Communicator;
import shadattonmoy.interfragmentcommunication.R;


public class fragment_A extends android.app.Fragment implements View.OnClickListener {

    Button button;
    int count = 0;
    Communicator comm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null)
        {
            count=0;
        }
        else
        {
            count = savedInstanceState.getInt("counter");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = (Button) getActivity().findViewById(R.id.button);
        comm = (Communicator) getActivity();
        button.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",count);
    }

    @Override
    public void onClick(View v) {
        count++;
        comm.respond("The button was clicked "+count+" times");
    }
}
