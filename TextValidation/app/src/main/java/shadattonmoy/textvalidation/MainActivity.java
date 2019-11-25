package shadattonmoy.textvalidation;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {


    String mess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText myText = (EditText)findViewById(R.id.editText);
        final TextView msg = (TextView)findViewById(R.id.textView2);

        /*start of addTextChangeListener()*/
        myText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                msg.setText("Before Text Change");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                msg.setText("On Text Change");
            }

            @Override
            public void afterTextChanged(Editable s) {
                String val = s.toString();
                if(!val.isEmpty()) {
                    int num = Integer.parseInt(val);
                    int mod = num%2;
                    msg.setText(Integer.toString(mod));
                }
            }
        });
        /*End of addTextChangeListener*/

        /*start of onClickListener*/
        final CheckBox mod2 = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox mod3 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox mod5 = (CheckBox) findViewById(R.id.checkBox3);
        mod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.setText("Mod 2 will be performed");

            }
        });

        mod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.setText("Mod 3 will be performed");
            }
        });

        mod5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.setText("Mod 5 will be performed");
            }
        });
        /*end of onClickListener*/

        /*start of toggle button*/
        ToggleButton tb = (ToggleButton) findViewById(R.id.toggleButton);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RelativeLayout r = (RelativeLayout) findViewById(R.id.activity_main);
                TextView input = (TextView) findViewById(R.id.inputValue);
                if(isChecked)
                {
                    r.setBackgroundColor(Color.BLACK);
                    mod2.setTextColor(Color.WHITE);
                    mod3.setTextColor(Color.WHITE);
                    mod5.setTextColor(Color.WHITE);
                    input.setTextColor(Color.WHITE);
                    buttonView.setBackgroundColor(Color.parseColor("#7f8c8d"));
                }
                else
                {
                    r.setBackgroundColor(Color.WHITE);
                    mod2.setTextColor(Color.BLACK);
                    mod3.setTextColor(Color.BLACK);
                    mod5.setTextColor(Color.BLACK);
                    input.setTextColor(Color.BLACK);
                    buttonView.setBackgroundColor(Color.BLACK);

                }
            }
        });



        /*end of toggle button*/

    }
}