package com.gomez.androidapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button btnCreators, btnFind;
    Intent creatorPage, indexPage, templatePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCreators = findViewById(R.id.btnCreators);
        btnFind = findViewById(R.id.btnFind);

        creatorPage = new Intent(this, Creators.class);
       //templatePage = new Intent(this, Template.class);
        indexPage = new Intent(this, Index.class);

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /*Restaurants test;
                test = new Restaurants(1, "name of the restaurant");

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainMenu.this);

                startActivity(indexPage);
                */
                startActivity(indexPage);


            }
        });

        btnCreators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("in creator");
                startActivity(creatorPage);




            }
        });





    }
}