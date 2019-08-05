package shadattonmoy.flexibleuiusingfragment;

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
    String[] description;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description,container,false);
        text = (TextView) view.findViewById(R.id.textView);
        Resources res = getResources();
        description = res.getStringArray(R.array.description);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void changeData(int index)
    {
        text.setText(description[index]);
    }

}
