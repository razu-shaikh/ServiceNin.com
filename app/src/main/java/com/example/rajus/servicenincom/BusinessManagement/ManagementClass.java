package com.example.rajus.servicenincom.BusinessManagement;

/**
 * Created by rajus on 11/7/2018.
 */

public class ManagementClass {
    public String managementCompanyName;
    public String managementCompanyAddress;

    public ManagementClass() {
    }

    public ManagementClass(String managementCompanyName, String managementCompanyAddress) {
        this.managementCompanyName = managementCompanyName;
        this.managementCompanyAddress = managementCompanyAddress;
    }

    public String getManagementCompanyName() {
        return managementCompanyName;
    }

    public void setManagementCompanyName(String managementCompanyName) {
        this.managementCompanyName = managementCompanyName;
    }

    public String getManagementCompanyAddress() {
        return managementCompanyAddress;
    }

    public void setManagementCompanyAddress(String managementCompanyAddress) {
        this.managementCompanyAddress = managementCompanyAddress;
    }


}
