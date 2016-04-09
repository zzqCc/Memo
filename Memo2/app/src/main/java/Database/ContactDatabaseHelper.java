package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lx on 2016/4/5.
 */
public class ContactDatabaseHelper extends SQLiteOpenHelper {

    private Context contactContext;

    public final static String CREATE_CONTACT = "CREATE TABLE contact("
            + "_id INTEGER UNIQUE AUTOINCREMENT,"
            + "name TEXT,"
            + "is_friend BOOLEAN);";

    public ContactDatabaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
        contactContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){

    }


}
