package shadattonmoy.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    ListView l;
    String[] days = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday"};
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (ListView) findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        l.setAdapter(adapter);
        msg = (TextView)findViewById(R.id.textView);
        msg.setVisibility(TextView.GONE);
        l.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tmp = (TextView) view;
        String val = (String) tmp.getText();
        val = val + " is at position " + position;
        msg.setText(val);
        msg.setVisibility(TextView.VISIBLE);


    }
}
