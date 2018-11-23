package com.example.rajus.servicenincom.CarRent;

/**
 * Created by rajus on 10/18/2018.
 */

public class RentClass {

    public String vehiclesName;
    public String vehiclesCondition;
    public String minimumRent;
    public String serviceArea;
    public String imageURL;
    public Object key;
    public RentClass()
    {

    }

    public RentClass(String vehiclesName, String vehiclesCondition, String minimumRent,  String serviceArea, String imageURL) {
        this.vehiclesName = vehiclesName;
        this.vehiclesCondition = vehiclesCondition;
        this.minimumRent = minimumRent;
        this.serviceArea = serviceArea;
        this.imageURL = imageURL;
    }

    public String getVehiclesName() {
        return vehiclesName;
    }

    public void setVehiclesName(String vehiclesName) {
        this.vehiclesName = vehiclesName;
    }

    public String getVehiclesCondition() {
        return vehiclesCondition;
    }

    public void setVehiclesCondition(String vehiclesCondition) {
        this.vehiclesCondition = vehiclesCondition;
    }

    public String getMinimumRent() {
        return minimumRent;
    }

    public void setMinimumRent(String minimumRent) {
        this.minimumRent = minimumRent;
    }


    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getKey() {
        return key;
    }
}
