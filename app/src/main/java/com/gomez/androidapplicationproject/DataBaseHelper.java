package com.gomez.androidapplicationproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TBrestaurants = "TBrestaurants";
    public static final String res_name = "res_name";
    public static final String res_id = "res_id";

    public static final String TBcomments = "TBcomments";
    public static final String comment_id = "comment_id";
    public static final String comment_string = "comment_string";
    public static final String comment_like = "comment_like";
    public static final String comment_res = "comment_res";




    private static final String createTBrestaurants =
            "CREATE TABLE " + TBrestaurants + " (" +
                    res_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    res_name + " TEXT," + " TEXT)";

    private static final String createTBcomments = "CREATE TABLE " + TBcomments + " (" +
                    comment_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    comment_string + " TEXT, " +
                    comment_like + " BOOLEAN, " +
                    comment_res + " TEXT " +

                    ")";


    public DataBaseHelper(@Nullable Context context) {
        super(context, "DBrestaurant", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTBcomments);
        db.execSQL(createTBrestaurants);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

   /* public void addOne(Restaurants restaurants){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //cv.put(res_name, restaurants.setRes_name());

        //db.insert(TBrestaurants, null, cv);

        long newRowID = db.insert(TBrestaurants, null, cv);


    }*/

    public boolean addComment(Comment comment)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(comment_string, comment.getComment_string());
        cv.put(comment_like, comment.getComment_like());
        cv.put(comment_res, comment.getComment_res());

        long insert = db.insert(TBcomments, null, cv);

        if (insert == -1)
        {
            return false;
        }
        else
            return true;
    }


    /*public List<Comment> getAllComment()
    {
        List<Comment> returnList = new ArrayList<>();

        String query = "SELECT * FROM " + TBcomments;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            do{
                int commentID = cursor.getInt(0);
                String commentString = cursor.getString(1);
                Boolean commentLike = cursor.getInt(2) == 1 ? true:false;

                Comment newComment = new Comment(commentID, commentString, commentLike);
                returnList.add(newComment);

            }while(cursor.moveToNext());
        }
        else
        {

        }

        cursor.close();
        db.close();


        return  returnList;
    }*/



    public Cursor getListContents(String res)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT comment_string FROM " + TBcomments + " WHERE comment_res=" + res,null);
        //db.close(); //ooooy nag lagay ka ng close dito // baka edto dahilan kung bakit di gagana mamaya
        return data;
    }

    public Cursor getLikeCount(String res)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT comment_like FROM " + TBcomments + " WHERE comment_res=" + res + " AND comment_like=1 ", null);
        return data;
    }



   public Cursor getDislikeCount(String res)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT comment_like FROM " + TBcomments + " WHERE comment_res=" + res + " AND comment_like=0 ", null);
        return data;
    }







    //laksdjflaksjdflkasjdflkasdflkj

}



