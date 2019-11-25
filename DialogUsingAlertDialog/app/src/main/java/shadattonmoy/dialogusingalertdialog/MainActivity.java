package shadattonmoy.dialogusingalertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openDialog(View view)
    {
        myDialog dialog = new myDialog();
        dialog.show(getFragmentManager(),"myDialog");
    }
}
