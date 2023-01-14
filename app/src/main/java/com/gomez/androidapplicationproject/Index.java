package com.gomez.androidapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Index extends AppCompatActivity {
    ImageButton btncafe, btneight, btngolden;
    Intent cafePage, eightPage, goldenPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        cafePage = new Intent(this, CafeEnzo.class);
        eightPage = new Intent(this, EightCuts.class);
        goldenPage = new Intent(this, GoldenCrown.class);

        btncafe = findViewById(R.id.btnCafe);
        btneight = findViewById(R.id.btnEight);
        btngolden = findViewById(R.id.btnGolden);


        btncafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(cafePage);
            }
        });

        btneight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(eightPage);
            }
        });

        btngolden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goldenPage);
            }
        });





    }
}