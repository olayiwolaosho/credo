package com.example.crdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.crdemo.services.HttpService;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        HttpService.login();
    }
}