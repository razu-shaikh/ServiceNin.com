package com.example.rajus.servicenincom.DailyLaunch;

/**
 * Created by rajus on 10/6/2018.
 */

public class Upload {
    public String resturantName;
    public String location;
    public String time;
    public String imageURL;
    public Object key;

    public Upload() {
    }

    public Upload(String resturantName, String location, String time,String url) {
        this.resturantName = resturantName;
        this.location = location;
        this.time = time;
        this.imageURL= url;
    }

    public String getResturantName() {
        return resturantName;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getKey() {
        return key;
    }

}
