package shadattonmoy.listviewwithimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView l;
    String[] days = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (ListView) findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.mylayout,R.id.textView,days);
        l.setAdapter(adapter);
    }
}
