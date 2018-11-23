package com.example.rajus.servicenincom.ItPackage;

/**
 * Created by rajus on 10/20/2018.
 */

public class ItClass {

    String companyName;
    String companyAddress;
    String serviceSection;
    public String imageURL;

    public ItClass() {
    }

    public ItClass(String companyName, String companyAddress,  String serviceSection, String imageURL) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.serviceSection = serviceSection;
        this.imageURL = imageURL;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getServiceSection() {
        return serviceSection;
    }

    public void setServiceSection(String serviceSection) {
        this.serviceSection = serviceSection;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
