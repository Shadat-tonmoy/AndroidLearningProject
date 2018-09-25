package shadattonmoy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button B = (Button) findViewById(R.id.button);
        Button B2 = (Button) findViewById(R.id.button2);
        TextView msg = (TextView) findViewById(R.id.msg);
        B.setOnClickListener(new loginButton());
        B2.setOnClickListener(resetButton);
        Button mapbtn = (Button) findViewById(R.id.map);
        mapbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                Intent chooser = Intent.createChooser(i,"Pick an Application");
                i.setData(Uri.parse("geo:10,10"));
                startActivity(chooser);
            }
        });
        Button emailbtn = (Button) findViewById(R.id.emailbtn);
        emailbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("market://details?id=com.degoo.android&hl=en"));
                Intent chooser = Intent.createChooser(i,"Pick an Application");
                startActivity(chooser);
            }
        });
        Button sendemail = (Button) findViewById(R.id.sendemail);
        sendemail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL,"shadat.tonmoy@gmail.com");
                i.putExtra(Intent.EXTRA_SUBJECT,"Test Email");
                String body = "This is the main text of the email. Hi buddy whats up! It's from the coolest android app ever";
                i.putExtra(Intent.EXTRA_TEXT,body);
                i.setType("message/rfc822");
                Intent chooser = Intent.createChooser(i,"Choose an app");
                startActivity(chooser);
            }
        });

    }
    //using inner class
    class loginButton implements OnClickListener{

        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            i.setClassName("shadattonmoy.myapplication","shadattonmoy.myapplication.LoginScreen");
            startActivity(i);

        }
    }
    //using inner class
    class resetButton implements OnClickListener{

        @Override
        public void onClick(View v) {
            TextView msg = (TextView) findViewById(R.id.msg);
            msg.setText("Reset Button was Clicked");
        }
    }
    //using annonymous inner class
    OnClickListener loginButton = new OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView msg = (TextView) findViewById(R.id.msg);
            msg.setText("Login Button");
        }
    };
    //using annonymous inner class
    OnClickListener resetButton = new OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView msg = (TextView) findViewById(R.id.msg);
            msg.setText("Reset Button");
        }
    };



    /*@Override
    public void onClick(View v) {
        int id = v.getId();
        Button B = (Button) findViewById(R.id.button);
        int idB = B.getId();
        Button B2 = (Button) findViewById(R.id.button2);
        int idB2 = B2.getId();
        //int idbtn1 = (int) findViewById(R.id.button);
        if(id==idB)
        {
            EditText username = (EditText) findViewById(R.id.username);
            Editable st = username.getText();
            TextView msg = (TextView) findViewById(R.id.msg);
            EditText password = (EditText) findViewById(R.id.password);
            Editable ps = password.getText();
            msg.setText("Welcome "+st+"\nYour Password is "+ps+"\n and ID is "+id+" \nButton ID is "+idB);
        }
        else if(id==idB2)
        {
            EditText username = (EditText) findViewById(R.id.username);
            EditText password = (EditText) findViewById(R.id.password);
            username.setText("");
            password.setText("");
            TextView msg = (TextView) findViewById(R.id.msg);
            msg.setText("Field was reset");
        }
    }*/
}
