package com.example.contact;

/**
 * Created by ccccc on 2016/4/13.
 */
public class Contact {
    private String name;

    private String information;

    public Contact(String name,String information){
        this.name = name;
        this.information = information;
    }

    public String getName(){
        return name;
    }

    public String getInformation(){
        return information;
    }
}
