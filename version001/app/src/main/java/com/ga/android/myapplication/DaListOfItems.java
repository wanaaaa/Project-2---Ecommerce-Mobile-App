package com.ga.android.myapplication;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/20/16.
 */

//It save each item from sqlite data base.
//When this app starts, each tiem in data base will be saved in this class.
// and then it will be used for recyler view.

public class DaListOfItems {
    private static DaListOfItems daListOfItems = null;
    ArrayList<DaIndiItem> itemArray;

    private DaListOfItems() {
        itemArray = new ArrayList<DaIndiItem>();
    }
}
