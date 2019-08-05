package shadattonmoy.framelayout;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img1,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = (ImageView) findViewById(R.id.imageView5);
        img2 = (ImageView) findViewById(R.id.imageView6);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        TextView t = (TextView) findViewById(R.id.textView);
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/aa.TTF");
        t.setTypeface(font);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==img1.getId())
        {
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
        }
        else
        {
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
        }

    }
}
