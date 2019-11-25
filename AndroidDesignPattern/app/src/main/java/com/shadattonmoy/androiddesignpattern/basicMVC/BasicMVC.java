package com.shadattonmoy.androiddesignpattern.basicMVC;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nex3z.notificationbadge.NotificationBadge;
import com.shadattonmoy.androiddesignpattern.R;
import com.shadattonmoy.androiddesignpattern.basicMVC.model.Cart;
import com.shadattonmoy.androiddesignpattern.basicMVC.model.Item;

import java.util.Observable;
import java.util.Observer;



//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;

public class BasicMVC extends AppCompatActivity implements Observer {

//    @BindView(R.id.add_to_cart)
    Button addToCardButton;
//    @BindView(R.id.item_counter)
    NotificationBadge itemCounter;
//    @BindView(R.id.total_price)
    TextView totalPriceView;
    private Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_mvc);
        init();

    }

    @Override
    public void update(Observable o, Object arg) {
        Cart cart= (Cart) o;
        int totalItem = cart.getTotalItem();
        double totalPrice = cart.getTotalPrice();
        itemCounter.setText(totalItem+"");
        totalPriceView.setText("Total Price "+totalPrice);


    }

//    @OnClick(R.id.add_to_cart)
    private void updateCart()
    {
        cart.addItem(new Item("item",10));

    }

    private void init()
    {
        cart = Cart.getInstance();
        cart.addObserver(this);
        addToCardButton = findViewById(R.id.add_to_cart);
        itemCounter = findViewById(R.id.item_counter);
        totalPriceView = findViewById(R.id.total_price);
        addToCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCart();
            }
        });
//        ButterKnife.bind(this);

    }
}
