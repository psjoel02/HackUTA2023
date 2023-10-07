package com.example.hackuta2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Nationwide is on your side");

        /*Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        this.finish();*/
    }
}