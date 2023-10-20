package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TickerViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedViewModel = new ViewModelProvider(this).get(TickerViewModel.class);





        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED){

            String[] permission = new String[]{Manifest.permission.RECEIVE_SMS};
            ActivityCompat.requestPermissions(this,permission, 101);

        }
        public TickerViewModel getSharedViewModel(){
            return sharedViewModel;
        }
}}