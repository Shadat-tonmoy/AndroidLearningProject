package shadattonmoy.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button one,two,three,four,five,six,seven,eight,nine,zero;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        msg = (TextView) findViewById(R.id.disp);
        one.setOnClickListener(new keyListener());
    }
    public class keyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int ID = v.getId();
            if(ID==one.getId())
            {
                msg.setText("1");


            }

        }
    }
}
