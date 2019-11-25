
package shadattonmoy.layoutusingjava;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    TextView t;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll = new LinearLayout(this);
        t = new TextView(this);
        b = new Button(this);
        LayoutParams matchParent = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        LayoutParams wrapContent = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(matchParent);
        ll.setBackgroundColor(Color.WHITE);
        t.setLayoutParams(wrapContent);
        b.setLayoutParams(wrapContent);
        t.setText("Hello World");
        t.setTextColor(Color.BLACK);
        b.setTextColor(Color.WHITE);
        b.setText("Submit");
        b.setBackgroundColor(Color.RED);
        ll.addView(t);
        ll.addView(b);

        setContentView(ll);
    }
}
