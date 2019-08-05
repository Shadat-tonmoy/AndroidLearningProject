package shadattonmoy.flexibleuiusingfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Intent intent = getIntent();
        int index = intent.getIntExtra("index",0);
        Description desc = (Description) getFragmentManager().findFragmentById(R.id.fragment2);
        if(desc!=null)
        {
            desc.changeData(index);
        }


    }
}
