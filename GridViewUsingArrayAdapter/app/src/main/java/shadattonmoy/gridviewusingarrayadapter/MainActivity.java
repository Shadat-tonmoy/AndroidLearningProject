package shadattonmoy.gridviewusingarrayadapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String [] names,regNo,email;
    int[] images = {R.drawable.i2014331070,R.drawable.i2014331063,R.drawable.i2014331062,R.drawable.i2014331009,R.drawable.i2014331064};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        names = res.getStringArray(R.array.names);
        regNo = res.getStringArray(R.array.regNo);
        email = res.getStringArray(R.array.email);
        GridView grid = (GridView) findViewById(R.id.gridView);
        myAdapter adapter = new myAdapter(this,names,regNo,email,images);
        grid.setAdapter(adapter);


    }
}
class myAdapter extends ArrayAdapter<String>{
    String [] names,regNo,email;
    Context context;
    int[] images;
    myAdapter(Context c,String[] names,String[] regNo,String[] email,int[] images)
    {
        super(c,R.layout.single_cell,R.id.nameText,names);
        this.names=names;
        this.regNo = regNo;
        this.email = email;
        this.context = c;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if(row==null)
        {
            LayoutInflater l = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row =  l.inflate(R.layout.single_cell,parent,false);
        }
        TextView myName = (TextView) row.findViewById(R.id.nameText);
        TextView myReg = (TextView) row.findViewById(R.id.regNo);
        TextView myEmail = (TextView) row.findViewById(R.id.email);
        ImageView myImage = (ImageView) row.findViewById(R.id.imageView);

        myName.setText(names[position]);
        myReg.setText(regNo[position]);
        myEmail.setText(email[position]);
        myImage.setImageResource(images[position]);

        return row;
    }
}
