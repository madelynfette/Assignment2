package com.example.assignment2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {


    private TickerViewModel mViewModel;
    ListView list_view;




    public WebViewFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static WebViewFragment newInstance(String param1, String param2) {
        WebViewFragment fragment = new WebViewFragment();
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

        View inflate = inflater.inflate(R.layout.fragment_web_view, container, false);
        list_view = inflate.findViewById(R.id.list_view);
        return inflate;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInsuranceState){
        super.onActivityCreated(savedInsuranceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(TickerViewModel.class);
        mViewModel.getTickers().observe(getViewLifecycleOwner(), new Observer<LinkedList<Ticker>>() {
            @Override
            public void onChanged(LinkedList<Ticker> tickers) {
                ArrayAdapter<Ticker> adapter = new ArrayAdapter<Ticker>(requireActivity(), android.R.layout.simple_list_item_1, mViewModel.getTickers().getValue());
                list_view.setAdapter(adapter);

            }

        };}
}

