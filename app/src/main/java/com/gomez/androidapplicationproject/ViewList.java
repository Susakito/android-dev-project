package com.gomez.androidapplicationproject;

import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewList extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_enzo);



    }

    public void show(String res)
    {
        ListView listView= (ListView) findViewById(R.id.commentSectionList);

        dataBaseHelper = new DataBaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = dataBaseHelper.getListContents(res);

        if(data.getCount() == 0)
        {

        }

        else
        {
            while(data.moveToNext())
            {
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
