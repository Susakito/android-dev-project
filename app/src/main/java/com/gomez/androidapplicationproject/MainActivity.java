package com.gomez.androidapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        handler.postDelayed(this::Home, 2000);



    }

    public void Home()
    {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }


}