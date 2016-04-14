package com.example.memo;

/**
 * Created by ccccc on 2016/4/12.
 */
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;


import com.example.R;
import com.example.database.MemoDatabaseHelper;

public class MemoActivity extends Activity {
    private MemoDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        dbHelper = new MemoDatabaseHelper(this,"Memo_main.db",null,2);
        db = dbHelper.getWritableDatabase();

        String sql = "SELECT * FROM memo WHERE d_day>datetime('now','localtime') AND " +
                "is_completed==0 ORDER BY d_day DESC;";

        Cursor cursor = db.rawQuery(sql,null);
        ListView listView = (ListView) findViewById(R.id.memo_listView);
        MemoCursorAdapter memoCursorAdapter = new MemoCursorAdapter(this,cursor,0);//flags
        listView.setAdapter(memoCursorAdapter);


    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if( db!=null && db.isOpen() )
            db.close();
    }


}
