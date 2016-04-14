package com.example.memo;

/**
 * Created by ccccc on 2016/4/14.
 */
public class Memo {
    private String title;
    private String date;

    public Memo(String title,String date){
        this.title = title;
        this.date = date;
    }

    public String getTitle(){ return title; }

    public String getDate(){ return date; }
}
