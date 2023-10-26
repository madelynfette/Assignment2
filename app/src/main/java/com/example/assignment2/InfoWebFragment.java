package com.example.assignment2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class InfoWebFragment extends Fragment {


    private TickerViewModel sharedViewModel;

    WebView webview;

    public InfoWebFragment() {

    }

    public static InfoWebFragment newInstance(String param1, String param2) {
        InfoWebFragment fragment = new InfoWebFragment();
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

        View inflate = inflater.inflate(R.layout.info_web_fragment, container, false);
        webview = inflate.findViewById(R.id.web_view);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("https://seekingalpha.com/");
        return inflate;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInsuranceState){
        super.onActivityCreated(savedInsuranceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(TickerViewModel.class);
        Observer<String> observer = new Observer<String>(){
            @Override
            public void onChanged(String s) {
                webview.loadUrl(s);
            }

        };
            sharedViewModel.getSelectedTicker().observe(getViewLifecycleOwner(),observer);

            }

}

