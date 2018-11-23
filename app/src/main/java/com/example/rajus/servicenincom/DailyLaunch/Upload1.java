package com.example.rajus.servicenincom.DailyLaunch;

/**
 * Created by rajus on 10/8/2018.
 */

public class Upload1 {


    public String itemName;
    public String itemPrice;
    public String imageURL1;
    public Object key;

    public Upload1() {
    }

    public Upload1(String itemName, String itemPrice, String imageURL1) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.imageURL1 = imageURL1;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getImageURL1() {
        return imageURL1;
    }

    public void setImageURL1(String imageURL1) {
        this.imageURL1 = imageURL1;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getKey() {
        return key;
    }



}
