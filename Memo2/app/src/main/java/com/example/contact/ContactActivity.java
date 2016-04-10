package com.example.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;


import com.example.R;
import com.example.database.MemoDatabaseHelper;

/**
 * Created by lx on 2016/4/4.
 */
public class ContactActivity extends Activity{
    private MemoDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        dbHelper = new MemoDatabaseHelper(this,"Memo_main.db",null,1);
        db = dbHelper.getWritableDatabase();

        String sql = "SELECT * FROM contact WHERE "/*+"is_friend==1"*/+";";//
        Cursor cursor = db.rawQuery(sql,null);
        ListView listView = (ListView) findViewById(R.id.contact_people_listview);
        ContactCursorAdapter contactCursorAdapter = new ContactCursorAdapter(this,cursor,0);//flags
        listView.setAdapter(contactCursorAdapter);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if( db!=null && db.isOpen() )
            db.close();
    }

}
