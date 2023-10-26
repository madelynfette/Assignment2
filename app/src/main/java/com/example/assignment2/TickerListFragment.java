package com.example.assignment2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class TickerListFragment extends Fragment {

    ListView list_view;
    public TickerViewModel sharedViewModel;

    public TickerListFragment() {
        // Required empty public constructor
    }

    public static TickerListFragment newInstance(String param1, String param2) {
        TickerListFragment fragment = new TickerListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentList = inflater.inflate(R.layout.ticker_list_fragment,container,false);
        list_view = fragmentList.findViewById(R.id.list_view);
        LinkedList<Ticker> tickers = new LinkedList<>();
        sharedViewModel = new ViewModelProvider(requireActivity()).get(TickerViewModel.class);
        tickers = sharedViewModel.getTickers().getValue();
        ArrayAdapter<Ticker> adapter = new ArrayAdapter<Ticker>(requireActivity(), android.R.layout.simple_list_item_1,tickers);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(listener);
        return fragmentList;

    }
    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Ticker clickedTicker = (Ticker) parent.getItemAtPosition(position);
            sharedViewModel.setSelectedTicker((clickedTicker).getLink());

        }
    };
    @Override
    public void onActivityCreated(@Nullable Bundle savedInsuranceState){
        super.onActivityCreated(savedInsuranceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(TickerViewModel.class);
        sharedViewModel.getTickers().observe(getViewLifecycleOwner(), new Observer<LinkedList<Ticker>>() {
            @Override
            public void onChanged(LinkedList<Ticker> tickers) {

          ArrayAdapter<Ticker> adapter = new ArrayAdapter<Ticker>(requireActivity(), android.R.layout.simple_list_item_1, tickers);
           list_view.setAdapter(adapter);

            }
        });
    }

}