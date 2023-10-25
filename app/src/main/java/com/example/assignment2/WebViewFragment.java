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
import android.widget.Toast;

import java.net.URL;
import java.util.LinkedList;
import java.util.Observable;


public class WebViewFragment extends Fragment {


    private TickerViewModel sharedViewModel;

    WebView webview;

    public WebViewFragment() {

    }

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

        View inflate = inflater.inflate(R.layout.fragment_web_view, container, false);
        webview = inflate.findViewById(R.id.web_view);
        webview.loadUrl("https://www.google.com/");
        return inflate;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInsuranceState){
        super.onActivityCreated(savedInsuranceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(TickerViewModel.class);

        Observer<String> observer = new Observer<String>(){
            @Override
            public void onChanged(String s) {
                //sharedViewModel.getSelectedTicker(s);
                webview.loadUrl(s);
            }

        };
            sharedViewModel.getSelectedTicker().observe(getViewLifecycleOwner(),observer);

            }

}

