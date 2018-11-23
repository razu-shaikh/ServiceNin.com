package com.example.rajus.servicenincom.OfficeAndHomeEquipment;

/**
 * Created by rajus on 11/9/2018.
 */

public class AddCompany {

    public String companyNameEq;
    public String companyAddressEq;

    public AddCompany() {
    }

    public AddCompany(String companyNameEq, String companyAddressEq) {
        this.companyNameEq = companyNameEq;
        this.companyAddressEq = companyAddressEq;
    }

    public String getCompanyNameEq() {
        return companyNameEq;
    }

    public void setCompanyNameEq(String companyNameEq) {
        this.companyNameEq = companyNameEq;
    }

    public String getCompanyAddressEq() {
        return companyAddressEq;
    }

    public void setCompanyAddressEq(String companyAddressEq) {
        this.companyAddressEq = companyAddressEq;
    }

}
