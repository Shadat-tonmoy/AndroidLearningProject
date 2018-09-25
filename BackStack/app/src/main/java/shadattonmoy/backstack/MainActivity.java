package shadattonmoy.backstack;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements android.app.FragmentManager.OnBackStackChangedListener {

    android.app.FragmentManager manager;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        message = (TextView) findViewById(R.id.message);
        manager.addOnBackStackChangedListener(this);
    }

    public void addA(View view){
        FragmentA fragmentA = new FragmentA();
        android.app.FragmentTransaction transaction;
        transaction = manager.beginTransaction();
        transaction.add(R.id.groupView,fragmentA,"fragment_a");
        transaction.addToBackStack("addA");
        transaction.commit();

    }
    public void removeA(View view){
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragment_a");
        if(fragmentA==null)
        {
            Toast.makeText(this,"Sorry No Fragment was found",Toast.LENGTH_SHORT).show();
        }
        else
        {
            android.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentA);
            transaction.addToBackStack("removeA");
            transaction.commit();
        }


    }
    public void replaceAB(View view){
        FragmentB fragmentB = new FragmentB();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.groupView,fragmentB,"ReplaceWithB");
        transaction.addToBackStack("replaceWithB");
        transaction.commit();

    }
    public void addB(View view){
        FragmentB fragmentB = new FragmentB();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.groupView,fragmentB,"fragment_b");
        transaction.addToBackStack("addB");
        transaction.commit();

    }
    public void removeB(View view){
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragment_b");
        if(fragmentB==null)
        {
            Toast.makeText(this,"Sorry No Fragment was Found",Toast.LENGTH_SHORT).show();
        }
        else
        {
            android.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentB);
            transaction.addToBackStack("removeB");
            transaction.commit();
        }

    }
    public void replaceBA(View view){
        FragmentA fragmentA = new FragmentA();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.groupView,fragmentA,"ReplaceWithA");
        transaction.addToBackStack("replaceWithA");
        transaction.commit();


    }
    public void back(View view){
        manager.popBackStack();

    }
    public void backToX(View view){
        manager.popBackStack("addB",0);

    }

    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBackStackChanged() {
        message.setText(message.getText() + "\n");
        message.setText(message.getText() + "Current Status of Backstack\n");

        int count = manager.getBackStackEntryCount();
        for(int i=count-1;i>=0;i--)
        {
            android.app.FragmentManager.BackStackEntry entry = (android.app.FragmentManager.BackStackEntry) manager.getBackStackEntryAt(i);
            message.setText(message.getText()+" "+entry.getName() +"\n");
        }
        message.setText(message.getText() + "\n");


    }
}
