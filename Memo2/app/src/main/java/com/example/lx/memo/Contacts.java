package com.example.lx.memo;

/**
 * Created by ccccc on 2016/4/5.
 */
public class Contacts {
    private String name;
    private String Information;
    private int imageId;
    public Contacts(String name, String Information , int imageId) {
        this.name = name;
        this.Information=Information;
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }
    public String getInformation(){
        return Information;
    }
    public int getImageId() {
        return imageId;
    }
}
