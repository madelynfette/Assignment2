package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED){

            String[] permission = new String[]{Manifest.permission.RECEIVE_SMS};
    }
}}