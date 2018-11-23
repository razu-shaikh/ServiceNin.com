package com.example.rajus.servicenincom.OfficeAndHomeEquipment;

/**
 * Created by rajus on 11/9/2018.
 */

public class AddItem {

    public String itemName;
    public String itemPrice;
    public String imageURL1;

    public AddItem() {
    }

    public AddItem(String itemName, String itemPrice, String imageURL1) {
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

}
