package shadattonmoy.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String[] name,reg,email;
    int [] images = {R.drawable.i2014331070,R.drawable.i2014331063,R.drawable.i2014331009,
            R.drawable.i2014331064,R.drawable.i2014331062,R.drawable.i2014331070,R.drawable.
            i2014331063,R.drawable.i2014331009,R.drawable.i2014331064,R.drawable.i2014331062,
            R.drawable.i2014331070,R.drawable.i2014331063,R.drawable.i2014331009,R.drawable.
            i2014331064,R.drawable.i2014331062,R.drawable.i2014331070,R.drawable.i2014331063,R.drawable.i2014331009,
            R.drawable.i2014331064,R.drawable.i2014331062,R.drawable.i2014331070,R.drawable.
            i2014331063,R.drawable.i2014331009,R.drawable.i2014331064,R.drawable.i2014331062,
            R.drawable.i2014331070,R.drawable.i2014331063,R.drawable.i2014331009,R.drawable.
            i2014331064,R.drawable.i2014331062};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        name = res.getStringArray(R.array.names);
        reg = res.getStringArray(R.array.reg);
        email = res.getStringArray(R.array.email);
        GridView grid = (GridView) findViewById(R.id.grid);
        myAdapter adapter = new myAdapter(this,name,reg,email,images);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        singleDesc tmpDesc = (singleDesc) view.getTag();
        singleCell tmp = (singleCell) tmpDesc.myImage.getTag();
        Intent intent = new Intent(this,myDialog.class);
        intent.putExtra("name",tmp.name);
        intent.putExtra("reg",tmp.reg);
        intent.putExtra("email",tmp.email);
        intent.putExtra("image",tmp.image);

        startActivity(intent);

    }
}
class singleCell{
    String name,reg,email;
    int image;
    singleCell(String name,String reg,String email,int image)
    {
        this.name=name;
        this.reg=reg;
        this.email=email;
        this.image=image;
    }
}
class singleDesc{
    TextView myName;
    TextView myReg;
    TextView myEmail;
    ImageView myImage;
    singleDesc(View row)
    {
        myName = (TextView) row.findViewById(R.id.textView2);
        myReg = (TextView) row.findViewById(R.id.textView3);
        myImage = (ImageView) row.findViewById(R.id.imageView);
        myEmail = (TextView) row.findViewById(R.id.textView4);
    }
}
class myAdapter extends BaseAdapter{
    ArrayList<singleCell> list;
    Context context;
    String[] name,reg,email;
    int[] images;
    myAdapter(Context context, String[] name, String[] reg,String[] email,int[] images)
    {
        this.context = context;
        this.name = name;
        this.reg = reg;
        this.email = email;
        this.images = images;
        list = new ArrayList<singleCell>();
        for(int i=0;i<name.length;i++)
        {
            singleCell tmp = new singleCell(name[i],reg[i],email[i],images[i]);
            list.add(tmp);
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
        singleDesc desc = null;
        if(row==null)
        {
            LayoutInflater l = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = l.inflate(R.layout.single_cell,parent,false);
            desc = new singleDesc(row);
            row.setTag(desc);
        }
        else
        {
            desc = (singleDesc) row.getTag();
        }
        singleCell tmp = list.get(position);
        desc.myName.setText(tmp.name);
        desc.myReg.setText(tmp.reg);
        desc.myEmail.setText(tmp.email);
        desc.myImage.setImageResource(tmp.image);
        desc.myImage.setTag(tmp);
        return row;
    }
}
