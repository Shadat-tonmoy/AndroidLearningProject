package shadattonmoy.spinner;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String[] days;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        days = res.getStringArray(R.array.days);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.single_row,R.id.textView,days);
        //ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.days,R.layout.single_row);
        spinner.setAdapter(adapter1);
        BlankFragment frag = new BlankFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.mainLayout,frag,"Fragment");
        transaction.commit();



    }
}
