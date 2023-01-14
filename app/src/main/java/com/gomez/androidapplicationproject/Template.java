/*package com.gomez.androidapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Template extends AppCompatActivity {


    ListView commentSectionList;

    Button btnSubmit;
    EditText comment;

    RadioGroup rate;
    RadioButton like, dislike;

    DataBaseHelper dataBaseHelper;
    ArrayList<String> comment_string, comment_like;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        commentSectionList = findViewById(R.id.commentSectionList);

        btnSubmit = findViewById(R.id.btnSubmitComment);
        comment = findViewById(R.id.edtComment);

        rate = findViewById(R.id.rate);
        like = (RadioButton)findViewById(R.id.rbLike);
        dislike = (RadioButton) findViewById(R.id.rbDislike);

        dataBaseHelper = new DataBaseHelper(Template.this);

        seeCommentSection();

       /* comment_string = new ArrayList<>();
        comment_like = new ArrayList<>();

        List<Comment> gettAllComment = dataBaseHelper.getAllComment();

        ArrayAdapter AllCommentAdapter = new ArrayAdapter<Comment>(this, android.R.layout.simple_expandable_list_item_1, gettAllComment);
        commentSectionList.setAdapter(AllCommentAdapter);
        */




/*
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


                Comment comment = new Comment(-1, com, i);
                //dataBaseHelper = new DataBaseHelper(Index.this);

                dataBaseHelper.addComment(comment);
                seeCommentSection();

                Toast.makeText(Template.this, "Comment Saved", Toast.LENGTH_SHORT).show();






            }
        });


    }

    public void seeCommentSection()
    {
        dataBaseHelper = new DataBaseHelper(Template.this);

        comment_string = new ArrayList<>();
        comment_like = new ArrayList<>();

        List<Comment> gettAllComment = dataBaseHelper.getAllComment();

        ArrayAdapter AllCommentAdapter = new ArrayAdapter<Comment>(this, android.R.layout.simple_expandable_list_item_1, gettAllComment);
        commentSectionList.setAdapter(AllCommentAdapter);
    }


}*/

