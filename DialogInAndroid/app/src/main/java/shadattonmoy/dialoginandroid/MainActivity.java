package shadattonmoy.dialoginandroid;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements myDialog.Communicator {

    TextView message;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void openDialog(View view){
        FragmentManager manager = getFragmentManager();
        myDialog dialog = new myDialog();
        dialog.show(manager,"myDialog");

    }

    @Override
    public void respond(String data) {
        message = (TextView) findViewById(R.id.message);
        message.setText(data);

    }
}
