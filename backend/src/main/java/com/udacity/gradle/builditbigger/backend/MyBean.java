package com.udacity.gradle.builditbigger.backend;

import com.cmpny.wca.jokeslibrary.MyJokes;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        myData = new MyJokes().getRandomJokes();
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}