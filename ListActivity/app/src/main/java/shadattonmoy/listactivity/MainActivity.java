package shadattonmoy.listactivity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    ListView l;
    TextView msg;
    String[] days = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        msg = (TextView) findViewById(R.id.textView);
        msg.setVisibility(TextView.GONE);
        l.setAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String val = (String)((TextView)v).getText() + " is at position "+position ;
        msg.setText(val);
        msg.setVisibility(TextView.VISIBLE);

    }
}
