package com.example.rajus.servicenincom.TourAndTravels;

/**
 * Created by rajus on 11/5/2018.
 */

public class TourClass {

    public String nameCompany;
    public String description;
    public  String price;
    public String nameCompany1;
    public String companyAddress;
    public String contactNumber;
    public String imageURL;
    public Object key;

    public TourClass() {

    }

    public TourClass(String nameCompany, String description, String price, String nameCompany1, String companyAddress, String contactNumber, String imageURL) {
        this.nameCompany = nameCompany;
        this.description = description;
        this.price = price;
        this.nameCompany1 = nameCompany1;
        this.companyAddress = companyAddress;
        this.contactNumber = contactNumber;
        this.imageURL = imageURL;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNameCompany1() {
        return nameCompany1;
    }

    public void setNameCompany1(String nameCompany1) {
        this.nameCompany1 = nameCompany1;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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
}
