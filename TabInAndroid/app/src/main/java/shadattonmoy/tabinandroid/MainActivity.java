package shadattonmoy.tabinandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myAdapter adapter = new myAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}
class myAdapter extends FragmentPagerAdapter{

    public myAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position==0)
        {
            fragment = new fragmentA();
        }
        else if(position==1)
        {
            fragment = new fragmentB();
        }
        else if(position==2)
        {
            fragment = new fragmentC();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position==0)
        {
            title = "Tab 1";
        }
        else if(position==1)
        {
            title = "Tab 2";
        }
        else if(position==2)
        {
            title = "Tab 3";
        }
        return title;
    }
}
