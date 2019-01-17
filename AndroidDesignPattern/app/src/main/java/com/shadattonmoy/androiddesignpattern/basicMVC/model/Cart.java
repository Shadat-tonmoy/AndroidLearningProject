package com.shadattonmoy.androiddesignpattern.basicMVC.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Cart extends Observable {
    private List<Item> items;
    private double totalPrice;
    private int totalItem;
    private static Cart cart = null;

    public static Cart getInstance()
    {
        if(cart==null)
        {
            cart = new Cart();
        }
        return cart;
    }

    private Cart() {

        items = new ArrayList<>();
        totalPrice = 0;
        totalItem = 0;
    }

    public void addItem(Item item)
    {
        items.add(item);
        totalPrice+=item.getPrice();
        totalItem++;
        setChanged();
        notifyObservers();
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public List<Item> getItems() {
        return items;
    }
}
