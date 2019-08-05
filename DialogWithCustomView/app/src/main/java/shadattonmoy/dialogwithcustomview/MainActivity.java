package shadattonmoy.dialogwithcustomview;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
    public void openFragment(View view)
    {
        myDialog dialog = new myDialog();
        android.app.FragmentManager manager = getFragmentManager();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group,dialog,"MyFragment");
        transaction.commit();



    }
}
