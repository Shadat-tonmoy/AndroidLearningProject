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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Titles extends android.app.Fragment implements AdapterView.OnItemClickListener {
    ListView list;
    String[] titles;
    Communicator comm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_titles,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = (ListView) getActivity().findViewById(R.id.listView);
        Resources res = getActivity().getResources();
        titles = res.getStringArray(R.array.titles);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,titles);
        list.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(),"OnItemClickListener",Toast.LENGTH_SHORT).show();
        comm.respond(position);
    }
    interface Communicator{
        public void respond(int index);
    }
    public void setCommunicator(Communicator comm)
    {
        this.comm = comm;
    }
}
