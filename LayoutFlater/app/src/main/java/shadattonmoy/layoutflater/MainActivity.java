package shadattonmoy.layoutflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    LinearLayout linear;
    LayoutInflater l;
    String[] names = {"ABC","DEF","GHI","JKL","MNO","ABC","DEF","GHI","JKL","MNO","ABC","DEF","GHI","JKL","MNO","ABC","DEF","GHI","JKL","MNO","ABC","DEF","GHI","JKL","MNO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = getLayoutInflater();
        //linear = (LinearLayout) findViewById(R.id.linear1);
        //View v = l.inflate(R.layout.mylaout,linear,false);
        list = (ListView) findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.singlerow,R.id.textView,names);
        list.setAdapter(adapter);
        //linear.addView(v);



    }
}
