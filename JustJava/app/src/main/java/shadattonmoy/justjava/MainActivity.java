package shadattonmoy.justjava;

import android.app.ActionBar;
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity=1;
    int price=5;
    Button confirmOrder;
    String orderSummary = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        confirmOrder = (Button)findViewById(R.id.confrimButton);
        confirmOrder.setVisibility(View.INVISIBLE);
    }

    /*
    *
    *
    *

     */
    public void submitOrder(View view)
    {
        CheckBox wippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox choclateCheckBox = (CheckBox) findViewById(R.id.choclate_checkbox);
        EditText name = (EditText) findViewById(R.id.name);
        boolean hasWippedCream = false;
        boolean hasChoclate = false;
        if(wippedCreamCheckBox.isChecked())
            hasWippedCream = true;
        if(choclateCheckBox.isChecked())
            hasChoclate = true;
        int price = calculatePrice(hasChoclate,hasWippedCream);
        String customerName = name.getText().toString();
        orderSummary = createOrderSummary(price,hasWippedCream,hasChoclate,customerName);
        display(quantity);
        displayPrice(orderSummary);
    }
    void display(int n)
    {
        TextView quantity_of_order = (TextView) findViewById(R.id.quantity_text_view);
        quantity_of_order.setText(""+n);
    }
    public String createOrderSummary(int price,boolean hasWippedCream,boolean hasChoclate,String name)
    {
        String wippedCream = "Wipped Cream is not included";
        String choclate = "Choclate is not included";
        if(hasWippedCream)
            wippedCream = "Wipped Cream is included";
        if(hasChoclate)
            choclate = "Choclate is included";
        String msg = "Name : "+name+"\nQuantity : "+quantity+"\n"+wippedCream+"\n"+choclate+"\nTotal : "+price+"\nThank You!!";
        return msg;
    }
    private int calculatePrice(boolean hasChoclate, boolean hasWippCream)
    {
        int price = quantity * this.price;
        if(hasChoclate)
            price+=(2*quantity);
        if(hasWippCream)
            price+=quantity;
        return price;
    }
    void displayPrice(String msg)
    {
        TextView price_text_view = (TextView) findViewById(R.id.price_text_view);
        price_text_view.setText(msg);
        confirmOrder.setVisibility(View.VISIBLE);
    }
    public void confirmOrder(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,"shadat.tonmoy@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just Java App Coffee Order");
        intent.putExtra(Intent.EXTRA_TEXT,orderSummary);
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivity(intent);
        else Toast.makeText(this,"No Email App is found",Toast.LENGTH_SHORT).show();

    }
    void increment(View view)
    {
        if(quantity<100)
        {
            quantity++;
            display(quantity);
        }
        else
        {
            Toast.makeText(this,"You can not order more than 100 coffee",Toast.LENGTH_SHORT).show();
        }
    }
    void decrement(View view)
    {
        if(quantity>1)
            quantity--;
        else {
            quantity=1;
            Toast.makeText(this,"You can not order less then one coffee",Toast.LENGTH_SHORT).show();
        }
        display(quantity);
    }
}
