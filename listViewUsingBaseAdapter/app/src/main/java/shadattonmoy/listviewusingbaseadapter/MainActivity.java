package shadattonmoy.listviewusingbaseadapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] names;
    String[] reg;
    String[] email;
    ListView list;
    int[] images = {R.drawable.i2014331070,R.drawable.i2014331063,R.drawable.i2014331009,R.drawable.i2014331064,R.drawable.i2014331062};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        names = res.getStringArray(R.array.names);
        reg = res.getStringArray(R.array.reg);
        email = res.getStringArray(R.array.email);
        list = (ListView) findViewById(R.id.list);
        myAdapter adapter = new myAdapter(this);
        list.setAdapter(adapter);
    }
}

class myAdapter2 extends ArrayAdapter<String>{

    String[] names,reg,email;
    int[] images;
    myAdapter2(Context c,String[] names,String[] reg,String[] email,int[] images)
    {
        super(c,R.layout.single_row,R.id.textView,names);
        this.names = names;
        this.reg = reg;
        this.email = email;
        this.images = images;
    }
    class viewHolder{
        TextView myName;
        TextView myReg;
        TextView myEmail;
        ImageView myImage;
        viewHolder(View row)
        {
            myName = (TextView) row.findViewById(R.id.textView);
            myReg = (TextView) row.findViewById(R.id.textView2);
            myEmail = (TextView) row.findViewById(R.id.textView4);
            myImage = (ImageView) row.findViewById(R.id.imageView);
        }


    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        viewHolder myViewHolder = null;
        if(row==null)
        {
            LayoutInflater l = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = l.inflate(R.layout.single_row,parent,false);
            myViewHolder = new viewHolder(row);
            row.setTag(myViewHolder);
        }
        else
        {
            myViewHolder = (viewHolder) row.getTag();

        }


        myViewHolder.myName.setText(names[position]);
        myViewHolder.myReg.setText(reg[position]);
        myViewHolder.myEmail.setText(email[position]);
        myViewHolder.myImage.setImageResource(images[position]);

        return row;
    }
}
class singleRow{
    String name,reg,email;
    int image;
    singleRow(String name,String reg,String email,int image)
    {
        this.name = name;
        this.reg = reg;
        this.email = email;
        this.image = image;
    }
}
class myAdapter extends BaseAdapter{

    String[] names,reg,email;

    ArrayList<singleRow> list;
    Context c;
    myAdapter(Context c)
    {
        Resources res = c.getResources();
        names = res.getStringArray(R.array.names);
        email = res.getStringArray(R.array.email);
        reg = res.getStringArray(R.array.reg);
        list = new ArrayList<singleRow>();
        this.c = c;
        int[] images = {R.drawable.i2014331070, R.drawable.i2014331063, R.drawable.i2014331009, R.drawable.i2014331064, R.drawable.i2014331062};
        for(int i=0;i<5;i++)
        {
            try {
                list.add(new singleRow(names[i],reg[i],email[i],images[i]));
            }catch (Exception e)
            {
              e.printStackTrace();
            }
        }

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        if(row==null)
        {
            LayoutInflater l = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = l.inflate(R.layout.single_row,parent,false);
        }
        TextView myName = (TextView) row.findViewById(R.id.textView);
        TextView myReg = (TextView) row.findViewById(R.id.textView2);
        TextView myEmail = (TextView) row.findViewById(R.id.textView4);
        ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
        singleRow tmp = list.get(position);
        myName.setText(tmp.name);
        myReg.setText(tmp.reg);
        myEmail.setText(tmp.email);
        myImage.setImageResource(tmp.image);
        return row;
    }
}
