package com.example.assignment2;

import androidx.annotation.NonNull;

public class Ticker {
    private String name;
    private String link;

    public Ticker(String name,String link){
        this.name = name;
        this.link = link;
    }

    public String getLink(){
        return link;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
