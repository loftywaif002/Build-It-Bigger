package com.udacity.gradle.builditbigger.backend;

import com.cmpny.wca.jokeslibrary.MyJokes;

import org.apache.commons.logging.Log;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        myData = new MyJokes().getRandomJokes();
        System.out.println(myData);
        return myData;
    }

    public void setData(String data){
        myData = data;
    }

}