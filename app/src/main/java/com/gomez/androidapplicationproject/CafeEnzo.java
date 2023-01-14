package com.gomez.androidapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CafeEnzo extends AppCompatActivity {

    int commentTableid = 1;

    TextView diet, features, location;

    ListView commentSectionList;

    Button btnSubmit;
    EditText comment;

    RadioGroup rate;
    RadioButton like, dislike;

    DataBaseHelper dataBaseHelper;
    ArrayList<String> comment_string, comment_like;

    TextView likeCounter, dislikeCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_enzo);

        diet = findViewById(R.id.txtDiet);
        features = findViewById(R.id.txtFeatures);

        commentSectionList = findViewById(R.id.commentSectionList);

        btnSubmit = findViewById(R.id.btnSubmitComment);
        comment = findViewById(R.id.edtComment);

        rate = findViewById(R.id.rate);
        like = (RadioButton)findViewById(R.id.rbLike);
        dislike = (RadioButton) findViewById(R.id.rbDislike);

        likeCounter = findViewById(R.id.likeCount);
        dislikeCounter = findViewById(R.id.dislikeCount);

        dataBaseHelper = new DataBaseHelper(CafeEnzo.this);

        //seeCommentSection();
        listComment("'enzo'");
        likeCounter.setText(Integer.toString(getLikeCounter()));
        dislikeCounter.setText(Integer.toString(getDislikeCounter()));





        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.enzodiet);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            diet.setText(new String(b));
        } catch (Exception e) {
            diet.setText("Error: can't show terms.");
        }

        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.enzofeatures);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            features.setText(new String(b));
        } catch (Exception e) {
            features.setText("Error: can't show terms.");
        }



        Uri enzo_uri = Uri.parse("https://www.google.com/maps/dir/14.7402357,120.9601226/14.735088,120.96127/@14.7641401,120.9357467,12z");
        location = findViewById(R.id.txtLocation);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webLoc = new Intent(Intent.ACTION_VIEW, enzo_uri);
                webLoc.setPackage("com.google.android.apps.maps");
                startActivity(webLoc);

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String com = comment.getText().toString();
                Boolean i;

                int rateId =rate.getCheckedRadioButtonId();

                if(like.isChecked())
                {
                    i = true;
                }
                else
                    i = false;


                Comment comment = new Comment(-1, com, i, "enzo");
                //dataBaseHelper = new DataBaseHelper(Index.this);

                dataBaseHelper.addComment(comment);
               // seeCommentSection();
                listComment("'enzo'");
                likeCounter.setText(Integer.toString(getLikeCounter()));
                dislikeCounter.setText(Integer.toString(getDislikeCounter()));

                Toast.makeText(CafeEnzo.this, "Comment Saved", Toast.LENGTH_SHORT).show();
            }
        });







    }



   /* public void seeCommentSection()
    {
        dataBaseHelper = new DataBaseHelper(CafeEnzo.this);

        comment_string = new ArrayList<>();
        comment_like = new ArrayList<>();

        List<Comment> gettAllComment = dataBaseHelper.getAllComment();

        ArrayAdapter AllCommentAdapter = new ArrayAdapter<Comment>(this, android.R.layout.simple_expandable_list_item_1, gettAllComment);
        commentSectionList.setAdapter(AllCommentAdapter);
    }*/

    public void listComment(String res)
    {

        ListView listView= (ListView) findViewById(R.id.commentSectionList);

        dataBaseHelper = new DataBaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = dataBaseHelper.getListContents( res);

        if(data.getCount() == 0)
        {
            Toast.makeText(this,   "Be the First One to Comment!", Toast.LENGTH_SHORT).show();
        }

        else
        {
            while(data.moveToNext())
            {
                theList.add(data.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
        }
    }

    public int getLikeCounter()
    {
        int i = 0;
        dataBaseHelper =  new DataBaseHelper(this);

        Cursor data = dataBaseHelper.getLikeCount("'enzo'");

        if(data.getCount()==0)
        {
            Toast.makeText(this,   "Be the First One to Like!", Toast.LENGTH_SHORT).show();
        }

        else
        {
            while(data.moveToNext())
            {
                i++;
            }

        }
        return i;
    }

    public int getDislikeCounter()
    {
        int i = 0;
        dataBaseHelper =  new DataBaseHelper(this);

        Cursor data = dataBaseHelper.getDislikeCount("'enzo'");

        if(data.getCount()==0)
        {

        }

        else
        {
            while(data.moveToNext())
            {
                i++;
            }

        }
        return i;
    }












}