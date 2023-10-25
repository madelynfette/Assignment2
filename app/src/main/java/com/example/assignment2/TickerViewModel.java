package com.example.assignment2;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.LinkedList;

public class TickerViewModel extends ViewModel {

    private MutableLiveData<LinkedList<Ticker>> tickers;
    public MutableLiveData<String>SelectedTicker;

    public void setSelectedTicker(String newTicker) {
        if (SelectedTicker == null){
            SelectedTicker = new MutableLiveData<>();
            SelectedTicker.setValue("https://seekingalpha.com");}
            SelectedTicker.setValue(newTicker);
    }

    public MutableLiveData<String> getSelectedTicker() {
        if (SelectedTicker == null){
            SelectedTicker = new MutableLiveData<>();
            SelectedTicker.setValue("https://seekingalpha.com");}
         return SelectedTicker;
    }

    public MutableLiveData<LinkedList<Ticker>>getTickers(){
        if (tickers == null){
            tickers = new MutableLiveData<>();
          LinkedList<Ticker> empty= new LinkedList<>();
            empty.add(new Ticker("BAC","https://seekingalpha.com/symbol/BAC"));
            empty.add(new Ticker("AAPL","https://seekingalpha.com/symbol/AAPL"));
            empty.add(new Ticker("DIS","https://seekingalpha.com/symbol/DIS"));
            tickers.setValue(empty);
        }
        return tickers;
    }
    public MutableLiveData<LinkedList<Ticker>>setTickers(){
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
        if(list.size() >= 6){
            list.add(t);
            tickers.setValue(list);
        }
    }
}
