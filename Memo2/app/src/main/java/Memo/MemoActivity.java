package Memo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lx.memo.R;

import Database.MemoDatabaseHelper;

/**
 * Created by lx on 2016/4/4.
 */
public class MemoActivity extends Activity {
    private MemoDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        dbHelper = new MemoDatabaseHelper(this,"Memo_main.db",null,1);
        db = dbHelper.getWritableDatabase();
        //-----------------------------------------------------------------------------
        //for test
        String sqltest = "insert into memo (title,content," +
                "d_day,send_day) values(?,?,datetime('now','localtime'),?);";
        db.execSQL(sqltest,new String[] {"hello","hello acmer","datetime('now','+1 hour','localtime')"});
        db.execSQL(sqltest,new String[] {"goodbye","goodbye acmer","datetime('now','-1 hour','localtime')"});
        db.execSQL(sqltest,new String[] {"good luck","good luck falling acmer","datetime('now','+1 day','localtime')"});
        db.execSQL(sqltest,new String[] {"touch over there","falling in this  acmer","datetime('now','+1 year','localtime')"});

        //-----------------------------------------------------------------------------
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
