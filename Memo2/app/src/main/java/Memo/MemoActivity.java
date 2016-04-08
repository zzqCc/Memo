package Memo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lx.memo.R;

import Database.MemoCursorAdapter;
import Database.MemoDatabaseHelper;

/**
 * Created by lx on 2016/4/4.
 */
public class MemoActivity extends Activity {
    private MemoDatabaseHelper dbHelper;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        dbHelper = new MemoDatabaseHelper(this, "Memo.db", null, 1);
        db = dbHelper.getReadableDatabase();
        //-----------------------------------------------------------------------------
        //for test utility
        String sqltest = "INSERT INTO memo(title,content,d_day)";
        db.execSQL(sqltest);
        //-----------------------------------------------------------------------------
        String sql = "SELECT * FROM memo WHERE is_completed==0 AND d_day>datetime('now','localtime') ORDER BY d_day desc;";
        Cursor cursor = db.rawQuery(sql,null);
        ListView memo_listview= (ListView) findViewById(R.id.memo_listView);
        MemoCursorAdapter memoItemAdapter = new MemoCursorAdapter(this,cursor,0);
        memo_listview.setAdapter(memoItemAdapter);

    }



    @Override
    public void onDestroy(){
        super.onDestroy();
        if( db != null && db.isOpen() ){
            db.close();
        }
    }


}
