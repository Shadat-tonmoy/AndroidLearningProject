package shadattonmoy.fragmentobjectstates;


import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.app.FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();

    }
    public void addA(View view)
    {
        //Log.e("Alert ","Onclick is triggred");
        FragmentA fragmentA = new FragmentA();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group,fragmentA,"FragmentA");
        transaction.commit();
        //Log.e("Alert : ","Transaction Commited");

    }
    public void RemoveA(View view)
    {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragmentA");
        if(fragmentA==null)
        {
            Toast.makeText(this,"Sorry No Fragment Found",Toast.LENGTH_SHORT).show();
        }
        else
        {
            android.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentA);
            transaction.commit();
        }

    }
    public void ReplaceAB(View view)
    {
        FragmentB fragmentB = new FragmentB();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group,fragmentB);
        transaction.commit();
    }
    public void AddB(View view)
    {
        FragmentB fragmentB = new FragmentB();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group,fragmentB,"FragmentB");
        transaction.commit();
    }
    public void RemoveB(View view)
    {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("FragmentB");
        if(fragmentB==null)
            Toast.makeText(this,"Sorry No Fragment is Found",Toast.LENGTH_SHORT).show();
        else
        {
            android.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentB);
            transaction.commit();

        }

    }
    public void ReplaceBA(View view)
    {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragmentA");
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group,fragmentA);
        transaction.commit();
    }
}
