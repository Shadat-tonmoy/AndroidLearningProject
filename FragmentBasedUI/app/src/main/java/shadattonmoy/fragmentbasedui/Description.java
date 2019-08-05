package shadattonmoy.fragmentbasedui;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Description extends android.app.Fragment {
    TextView text;
    String [] description;
    String data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description,container,false);
        if(savedInstanceState!=null)
        {
            data = savedInstanceState.getString("description");
            text = (TextView) view.findViewById(R.id.textView);
            text.setText(data);
        }
        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        text = (TextView) getActivity().findViewById(R.id.textView);
        Resources res = getActivity().getResources();
        description = res.getStringArray(R.array.description);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("description",data);
    }

    public void changeText(int i)
    {
        this.data = description[i];
        text.setText(data);
    }
}
