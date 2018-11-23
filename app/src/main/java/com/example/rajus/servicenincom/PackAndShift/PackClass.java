package com.example.rajus.servicenincom.PackAndShift;

/**
 * Created by rajus on 11/6/2018.
 */

public class PackClass {
    public String packCompanyName;
    public String packCompanyAddress;
    public String serviceArea;
    public String packRent;
    public String imageURL;
    public Object key;

    public PackClass() {
    }

    public PackClass(String packCompanyName, String packCompanyAddress, String serviceArea, String packRent,String imageURL) {
        this.packCompanyName = packCompanyName;
        this.packCompanyAddress = packCompanyAddress;
        this.serviceArea = serviceArea;
        this.packRent = packRent;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public String getPackCompanyName() {
        return packCompanyName;
    }

    public void setPackCompanyName(String packCompanyName) {
        this.packCompanyName = packCompanyName;
    }

    public String getPackCompanyAddress() {
        return packCompanyAddress;
    }

    public void setPackCompanyAddress(String packCompanyAddress) {
        this.packCompanyAddress = packCompanyAddress;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }


    public String getPackRent() {
        return packRent;
    }

    public void setPackRent(String packRent) {
        this.packRent = packRent;
    }
}
