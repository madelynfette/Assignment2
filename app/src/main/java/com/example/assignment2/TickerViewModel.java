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

    public void setSelectedTicker(MutableLiveData<String> selectedTicker) {
        if (SelectedTicker == null){
            SelectedTicker = new MutableLiveData<>();}
        SelectedTicker = selectedTicker;
        SelectedTicker.setValue("https://seekingalpha.com");
    }

    public MutableLiveData<String> getSelectedTicker(String s) {
        if (SelectedTicker == null){
            SelectedTicker = new MutableLiveData<>();}
        return SelectedTicker;
    }

    public MutableLiveData<LinkedList<Ticker>>getTickers(){
        if (tickers == null){
            tickers = new MutableLiveData<>();
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
