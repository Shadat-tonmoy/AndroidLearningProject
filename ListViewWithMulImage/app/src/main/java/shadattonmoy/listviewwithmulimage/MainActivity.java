package shadattonmoy.listviewwithmulimage;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    String[] titles;
    String [] description;
    int[] images = {R.drawable.facebook,R.drawable.twitter,R.drawable.googleplus,R.drawable.instagram,R.drawable.linkedin,R.drawable.pinterest};
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        titles = res.getStringArray(R.array.titles);
        description = res.getStringArray(R.array.description);
        l = (ListView) findViewById(R.id.list);
        myAdapter adapter = new myAdapter(this,titles,description,images);
        l.setAdapter(adapter);
    }
}

class myAdapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] titles;
    String[] description;
    myAdapter(Context c,String[] titles,String[] description,int[] images)
    {
        super(c,R.layout.single_row,R.id.textView,titles);
        this.context = c;
        this.images = images;
        this.titles = titles;
        this.description = description;
    }

    class viewHolder{
        ImageView myImage;
        TextView myTitle;
        TextView myDesc;
        viewHolder(View v)
        {
            myImage = (ImageView) v.findViewById(R.id.imageView);
            myTitle = (TextView) v.findViewById(R.id.textView);
            myDesc = (TextView) v.findViewById(R.id.textView2);
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        viewHolder myViewHolder = null;
        if(row==null)
        {
            LayoutInflater l = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = l.inflate(R.layout.single_row,parent,false);
            myViewHolder = new viewHolder(row);
            row.setTag(myViewHolder);
        }
        else
        {
            myViewHolder = (viewHolder) row.getTag();
        }
        //ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
        //TextView myTitle = (TextView) row.findViewById(R.id.textView);
        //TextView myDesc = (TextView) row.findViewById(R.id.textView2);
        myViewHolder.myImage.setImageResource(images[position]);
        myViewHolder.myTitle.setText(titles[position]);
        myViewHolder.myDesc.setText(description[position]);
        return row;
    }
}

