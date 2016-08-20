package com.ga.android.myapplication;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/27/16.
 */

//This class is for Shopping Cart. Individual item instance will be saved array list.
// This class make singleton which have only one instance.

//Making singleton
public class DaCartList {
    private static DaCartList daCartList = null;
    private static ArrayList<DaIndiItem> cartArray;

    private DaCartList() {
        cartArray = new ArrayList<DaIndiItem>();
    }

    public static DaCartList getInstance() {
        if (daCartList == null) {
            daCartList = new DaCartList();
        }
        return  daCartList;
    }

    // This is return array for cart
    public ArrayList<DaIndiItem> getCartArray() {
        return cartArray;
    }

    //This will show how many item it is in shopping cart.
    public int cartSize() {
        return cartArray.size();
    }

    //It will add selected item to shopping cart.
    public void addItem(DaIndiItem instance) {
        cartArray.add(instance);
    }

    //This remove selected individual item from shopping cart.
    public void removeAnItem(int i) {
        cartArray.remove(i);
    }

    // This makes shopping cart empty
    public void removeAll() {
        cartArray.clear();
    }

}
