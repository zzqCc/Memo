package Contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lx.memo.R;

import Database.MemoDatabaseHelper;

/**
 * Created by lx on 2016/4/9.
 */
public class contactGroupActivity extends Activity {
    private MemoDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_group);
        dbHelper = new MemoDatabaseHelper(this,"Memo_main.db",null,1);
        db = dbHelper.getWritableDatabase();

        String sql = "SELECT * FROM group ";
        Cursor cursor = db.rawQuery(sql,null);
        ListView listView = (ListView) findViewById(R.id.contact_people_listview);
        ContactGroupCursorAdapter contactCursorAdapter = new ContactGroupCursorAdapter(this,cursor,0);//flags
        listView.setAdapter(contactCursorAdapter);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if( db!=null && db.isOpen() )
            db.close();
    }

}
