package com.example.rajus.servicenincom.EventManagement;

/**
 * Created by rajus on 11/6/2018.
 */

public class EventClass {
    public String eventCompanyName;
    public String eventCompanyAddress;
    public String eventContact;
    public String eventPackage;
    public Object key;

    public EventClass() {
    }

    public EventClass(String eventCompanyName, String eventCompanyAddress, String eventContact, String eventPackage) {
        this.eventCompanyName = eventCompanyName;
        this.eventCompanyAddress = eventCompanyAddress;
        this.eventContact = eventContact;
        this.eventPackage = eventPackage;
    }

    public String getEventCompanyName() {
        return eventCompanyName;
    }

    public void setEventCompanyName(String eventCompanyName) {
        this.eventCompanyName = eventCompanyName;
    }

    public String getEventCompanyAddress() {
        return eventCompanyAddress;
    }

    public void setEventCompanyAddress(String eventCompanyAddress) {
        this.eventCompanyAddress = eventCompanyAddress;
    }

    public String getEventContact() {
        return eventContact;
    }

    public void setEventContact(String eventContact) {
        this.eventContact = eventContact;
    }

    public String getEventPackage() {
        return eventPackage;
    }

    public void setEventPackage(String eventPackage) {
        this.eventPackage = eventPackage;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }
}
