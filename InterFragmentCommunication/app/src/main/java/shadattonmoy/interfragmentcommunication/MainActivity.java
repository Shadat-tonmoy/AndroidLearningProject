package shadattonmoy.interfragmentcommunication;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import layout.*;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(String data) {
        android.app.FragmentManager manager = getFragmentManager();
        fragment_B f2 = (fragment_B) manager.findFragmentById(R.id.fragment2);
        f2.changeText(data);



    }
}
