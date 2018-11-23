package com.example.rajus.servicenincom.RegularService;

/**
 * Created by rajus on 11/7/2018.
 */

public class RegularClass {
    public String regularCompanyName;
    public String regularCompanyAddress;
    public String regularCompanyContact;
    public String regularMinimumRent;

    public RegularClass() {
    }

    public RegularClass(String regularCompanyName, String regularCompanyAddress, String regularCompanyContact, String regularMinimumRent) {
        this.regularCompanyName = regularCompanyName;
        this.regularCompanyAddress = regularCompanyAddress;
        this.regularCompanyContact = regularCompanyContact;
        this.regularMinimumRent = regularMinimumRent;
    }

    public String getRegularCompanyName() {
        return regularCompanyName;
    }

    public void setRegularCompanyName(String regularCompanyName) {
        this.regularCompanyName = regularCompanyName;
    }

    public String getRegularCompanyAddress() {
        return regularCompanyAddress;
    }

    public void setRegularCompanyAddress(String regularCompanyAddress) {
        this.regularCompanyAddress = regularCompanyAddress;
    }

    public String getRegularCompanyContact() {
        return regularCompanyContact;
    }

    public void setRegularCompanyContact(String regularCompanyContact) {
        this.regularCompanyContact = regularCompanyContact;
    }

    public String getRegularMinimumRent() {
        return regularMinimumRent;
    }

    public void setRegularMinimumRent(String regularMinimumRent) {
        this.regularMinimumRent = regularMinimumRent;
    }

}
