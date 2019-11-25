package shadattonmoy.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class myDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        Intent intent = getIntent();
        if(intent!=null)
        {
            String name = intent.getStringExtra("name");
            String reg = intent.getStringExtra("reg");
            String email = intent.getStringExtra("email");
            int image = intent.getIntExtra("image",R.drawable.i2014331070);
            ImageView dialogImage = (ImageView) findViewById(R.id.imageView2);
            TextView dialogName  = (TextView) findViewById(R.id.textView);
            TextView dialogReg  = (TextView) findViewById(R.id.textView5);
            TextView dialogEmail  = (TextView) findViewById(R.id.textView7);
            dialogImage.setImageResource(image);
            dialogName.setText(name);
            dialogReg.setText(reg);
            dialogEmail.setText(email);

        }


    }
    public void closeDialog(View v)
    {
        finish();
    }
}
