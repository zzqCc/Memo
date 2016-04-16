package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.memo.Memo;

/**
 * Created by ccccc on 2016/4/16.
 */
public class MemoDB extends SQLiteOpenHelper {
    //数据库版本号
    private static final int MEMO_VERSION=4;

    //数据库名称
    private static final String MEMO_NAME="test.db";

    public MemoDB(Context context){
        super(context,MEMO_NAME,null,MEMO_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据表

        String CREATE_TABLE_MEMO="CREATE TABLE "+ Memo.TABLE+"("
                +Memo.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +Memo.KEY_TITLE+" TEXT, "
                +Memo.KEY_DATE+" TEXT, "
                +Memo.KEY_CONTENT+" TEXT)";
        db.execSQL(CREATE_TABLE_MEMO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果旧表存在，删除，所以数据将会消失
        db.execSQL("DROP TABLE IF EXISTS "+ Memo.TABLE);

        //再次创建表
        onCreate(db);
    }
}
