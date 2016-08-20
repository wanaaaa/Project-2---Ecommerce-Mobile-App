package com.ga.android.myapplication;

/**
 * Created by wanmac on 7/20/16.
 */

//This class make an instance of each item to be saved.
//Eventually these will be saved in Array list.
// Each item instance have 4 variables. There are item name, description, image url.

public class DaIndiItem {
    String mIteTitle, mIteDescrip, mIteImgURL, mUserName;
    int mItePrice;
    boolean mQIteCart;

    public DaIndiItem(){
        mIteDescrip = "description asdf";
        mIteImgURL = "url asf";
        mUserName = "Wan";
        //mItePrice = 2345;
        mQIteCart = false;
    }

    public DaIndiItem(String iteTitle, int price){
        mIteTitle = iteTitle;
        mItePrice = price;
    }

    //To get title
    public String getIteTitle() {
        return mIteTitle;
    }

    //To set title
    public void setIteTitle(String str) {
        mIteTitle = str;
    }

    // To get price
    public int getItePrice() {
        return  mItePrice;
    }

    // To set price
    public void setItePrice(int price) {
        mItePrice = price;
    }
}
