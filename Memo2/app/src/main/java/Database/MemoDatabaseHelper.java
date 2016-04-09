package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lx on 2016/4/5.
 */
public class MemoDatabaseHelper extends SQLiteOpenHelper {

    private Context memoContext;
    public static final String CREATE_MEMO = "CREATE TABLE memo("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "send_day TEXT,"
            + "d_day TEXT,"
            + "title TEXT,"
            + "content TEXT NOT NULL,"
            + "from_groupId INTEGER,"
            + "from_personId INTEGER,"
            + "is_completed BOOLEAN DEFAULT false);";

    public MemoDatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
        memoContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_MEMO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){

    }

}
