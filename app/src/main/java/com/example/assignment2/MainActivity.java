package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.Format;

import kotlin.internal.AccessibleLateinitPropertyLiteral;

public class MainActivity extends AppCompatActivity {
   private TickerViewModel sharedViewModel;
   FragmentManager fg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fg = getSupportFragmentManager();
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String message = intent.getStringExtra("sms");

        sharedViewModel = new ViewModelProvider(this).get(TickerViewModel.class);
            if(savedInstanceState == null){
                fg.beginTransaction().replace(R.id.list_container,new TickerListFragment()).commit();
                fg.beginTransaction().replace(R.id.web_container,new InfoWebFragment()).commit();
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED){
                    String[] perms = new String[] {Manifest.permission.RECEIVE_SMS};
                    ActivityCompat.requestPermissions(this, perms, 101);
                }
            }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED){

            String[] permission = new String[]{Manifest.permission.RECEIVE_SMS};
            ActivityCompat.requestPermissions(this,permission, 101);
        }}
        public TickerViewModel getSharedViewModel(){
            return sharedViewModel;
        }
      @Override
    protected void onNewIntent( Intent intent){
        super.onNewIntent(intent);
          String smsInput = intent.getStringExtra("sms");


          if(smsInput.startsWith("Ticker:<<") && smsInput.endsWith(">>")){
              String stepOne = smsInput.replaceFirst("Ticker:<<","");
              String stepTwo = stepOne.replace(">>","");
              String ticName = stepTwo.toUpperCase();
              if (ticName.matches("[a-zA-Z]+")){
                  String ticLink = "https://seekingalpha.com/symbol/"+ ticName;
                  Ticker newTick = new Ticker(ticName,ticLink);
                  sharedViewModel.addTicker(newTick);
                  sharedViewModel.setSelectedTicker((newTick).getLink());;
              }
              else {
                  Toast.makeText(this, "The ticker you entered is invalid.", Toast.LENGTH_SHORT).show();
              }

          } else {
              Toast.makeText(this, "No valid watchlist entry was found.", Toast.LENGTH_SHORT).show();
          }}}








