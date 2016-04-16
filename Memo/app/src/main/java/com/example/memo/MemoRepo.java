package com.example.memo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.database.MemoDB;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ccccc on 2016/4/16.
 */
public class MemoRepo {
    private MemoDB dbHelper;

    public MemoRepo(Context context){
        dbHelper=new MemoDB(context);
    }

    public int insert(Memo memo){
        //打开连接，写入数据
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Memo.KEY_TITLE,memo.memo_title);
        values.put(Memo.KEY_DATE,memo.date);
        values.put(Memo.KEY_CONTENT,memo.memo_content);
        //
        long student_Id=db.insert(Memo.TABLE,null,values);
        db.close();
        return (int)student_Id;
    }

    public void delete(int student_Id){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.delete(Memo.TABLE,Memo.KEY_ID+"=?", new String[]{String.valueOf(student_Id)});
        db.close();
    }
    public void update(Memo memo){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(Memo.KEY_TITLE,memo.memo_title);
        values.put(Memo.KEY_DATE,memo.date);
        values.put(Memo.KEY_CONTENT,memo.memo_content);

        db.update(Memo.TABLE,values,Memo.KEY_ID+"=?",new String[] { String.valueOf(memo.memo_ID) });
        db.close();
    }

    public ArrayList<HashMap<String, String>> getStudentList(){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String selectQuery="SELECT "+
                Memo.KEY_ID+","+
                Memo.KEY_TITLE+","+
                Memo.KEY_DATE+","+
                Memo.KEY_CONTENT+" FROM "+Memo.TABLE;
        ArrayList<HashMap<String,String>> memoList=new ArrayList<HashMap<String, String>>();
        Cursor cursor=db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                HashMap<String,String> memo=new HashMap<String,String>();
                memo.put("_id",cursor.getString(cursor.getColumnIndex(Memo.KEY_ID)));
                memo.put("title",cursor.getString(cursor.getColumnIndex(Memo.KEY_TITLE)));
                memoList.add(memo);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return memoList;
    }

    public Memo getStudentById(int Id){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String selectQuery="SELECT "+
                Memo.KEY_ID + "," +
                Memo.KEY_TITLE + "," +
                Memo.KEY_DATE + "," +
                Memo.KEY_CONTENT +
                " FROM " + Memo.TABLE
                + " WHERE " +
                Memo.KEY_ID + "=?";
        int iCount=0;
        Memo memo=new Memo();
        Cursor cursor=db.rawQuery(selectQuery,new String[]{String.valueOf(Id)});
        if(cursor.moveToFirst()){
            do{
                memo.memo_ID =cursor.getInt(cursor.getColumnIndex(Memo.KEY_ID));
                memo.memo_title =cursor.getString(cursor.getColumnIndex(Memo.KEY_TITLE));
                memo.date  =cursor.getString(cursor.getColumnIndex(Memo.KEY_DATE));
                memo.memo_content =cursor.getString(cursor.getColumnIndex(Memo.KEY_CONTENT));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return memo;
    }
}
