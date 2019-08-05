package shadattonmoy.fragmentobjectstates;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class FragmentA extends android.app.Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Alert","onAttatch Method under A");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Alert","onCreate Method under A");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_,container,false);
        Log.d("Alert","onCreateView Method under A");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Alert","onActivityCreated Method under A");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Alert","onPause Method under A");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Alert","onStop Method under A");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Alert","onDestroy Method under A");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Alert","onDestroyView Method under A");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Alert","onDetach Method under A");
    }
}
