package com.example.assignment2;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.LinkedList;

public class TickerViewModel extends ViewModel {

    private MutableLiveData<LinkedList<Ticker>> tickers;

    public void setTickers(MutableLiveData<LinkedList<Ticker>> tickers){
        this.tickers = tickers;
    }
    public MutableLiveData<LinkedList<Ticker>>getTickers(){
        if (tickers == null){
            tickers = new MutableLiveData<>();
            LinkedList<Ticker> list = new LinkedList<>();
            list.add(new Ticker("BAC","https://seekingalpha.com/symbol/BAC"));
            list.add(new Ticker("AAPL","https://seekingalpha.com/symbol/AAPL"));
            list.add(new Ticker("DIS","https://seekingalpha.com/symbol/DIS"));
            tickers.setValue(list);
        }
        return tickers;
    }
    public void addTicker(Ticker t){
        LinkedList<Ticker> list = tickers.getValue();
        list.add(t);
        tickers.setValue(list);
    }
}
