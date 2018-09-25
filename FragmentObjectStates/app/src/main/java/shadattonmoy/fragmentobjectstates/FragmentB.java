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



public class FragmentB extends android.app.Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Alert of B","onAttatch method under B");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Alert of B","onCreate Method under B");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Alert of B","onCreateView Method under B");
        View view = inflater.inflate(R.layout.fragment_fragment_b,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Alert of B","onActivityCreated Method under B");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Alert of B","onPause Method under B");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Alert of B","onStop Method under B");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Alert of B","onDestroy Method under B");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Alert of B","onDestroyView Method under B");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Alert of B","onDetatch Method under B");
    }
}
