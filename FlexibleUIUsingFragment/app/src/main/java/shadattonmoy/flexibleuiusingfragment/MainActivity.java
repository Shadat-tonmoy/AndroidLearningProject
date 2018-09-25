package shadattonmoy.flexibleuiusingfragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Titles.Communicator{
    Titles titles;
    Description description;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        titles = (Titles) manager.findFragmentById(R.id.fragment);
        titles.setCommunicator(this);
    }

    @Override
    public void respond(int index) {
        description = (Description) manager.findFragmentById(R.id.fragment2);
        if(description!=null && description.isVisible())
        {
            description.changeData(index);
            Toast.makeText(this,"Main activity was called",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Another activity was called",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,AnotherActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }

    }
}
