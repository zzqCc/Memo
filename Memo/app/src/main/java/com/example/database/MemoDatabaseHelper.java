package com.example.database;

/**
 * Created by ccccc on 2016/4/12.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MemoDatabaseHelper extends SQLiteOpenHelper {

    private Context memoContext;
    public static final String CREATE_MEMO = "CREATE TABLE memo("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "send_day TEXT,"
            + "content TEXT NOT NULL,"
            + "title TEXT"
            + "d_day TEXT,"
            + "is_completed BOOLEAN DEFAULT 0,"
            + "from_groupId INTEGER,"
            + "from_personId INTEGER);";
    public  static final String CREATE_CONTACT = "CREATE TABLE contact(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "contact_id INTEGER," +
            "name TEXT);";
    public static final String CREATE_RELATION = "CREATE TABLE relation(" + //!public!
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "person_name TEXT);" ; //邻接矩阵
    public static final String CREATE_GROUP = "CREATE TABLE group(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "group_name TEXT);"; // store group name



    public MemoDatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
        memoContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        //-----------------------------------------------------------------------------
        //for test
        // memo test
        String sqltest = "insert into memo (title,content," +
                "d_day,send_day) values(?,?,datetime('now','localtime'),?);";
        db.execSQL(sqltest,new String[] {"hello","hello acmer","datetime('now','+1 hour','localtime')"});
        db.execSQL(sqltest,new String[] {"goodbye","goodbye acmer","datetime('now','-1 hour','localtime')"});
        db.execSQL(sqltest,new String[] {"good luck","good luck falling acmer","datetime('now','+1 day','localtime')"});
        db.execSQL(sqltest,new String[] {"touch over there","falling in this  acmer","datetime('now','+1 year','localtime')"});

        // insert contact, the number after the name is to specify the group they belong to ,
        // for example, boby138 belong to group1,group3 and group8
        sqltest = "INSERT INTO contact (contact_id,name) VALUES (312435432,\"boby138\");";
        db.execSQL(sqltest,null);
        sqltest = "INSERT INTO contact (contact_id,name) VALUES (312432,\"tomi145\");";
        db.execSQL(sqltest, null);
        sqltest = "INSERT INTO contact (contact_id,name) VALUES (31432,\"anna126\");";
        db.execSQL(sqltest,null);
        sqltest = "INSERT INTO contact (contact_id,name) VALUES (31243,\"andy456\");";
        db.execSQL(sqltest,null);
        sqltest = "INSERT INTO contact (contact_id,name) VALUES (32,\"john234\");";
        db.execSQL(sqltest,null);

        String sqltest2; // add group, it should be done in both RELATIONSHIP and GROUP table
        sqltest = "INSERT INTO group (group_name) VALUES (\"group1\")";
        sqltest2 = "ALTER TABLE relation ADD group1 BOOLEAN DEFAULT 0;";
        db.execSQL(sqltest,null); db.execSQL(sqltest2,null);
        sqltest = "INSERT INTO group (group_name) VALUES (\"group2\")";
        sqltest2 = "ALTER TABLE relation ADD group2 BOOLEAN DEFAULT 0;";
        db.execSQL(sqltest,null);db.execSQL(sqltest2,null);
        sqltest = "INSERT INTO group (group_name) VALUES (\"group3\")";
        sqltest2 = "ALTER TABLE relation ADD group3 BOOLEAN DEFAULT 0;";
        db.execSQL(sqltest,null);db.execSQL(sqltest2,null);
        sqltest = "INSERT INTO group (group_name) VALUES (\"group4\")";
        sqltest2 = "ALTER TABLE relation ADD group4 BOOLEAN DEFAULT 0;";
        db.execSQL(sqltest,null);db.execSQL(sqltest2,null);
        sqltest = "INSERT INTO group (group_name) VALUES (\"group5\")";
        sqltest2 = "ALTER TABLE relation ADD group5 BOOLEAN DEFAULT 0;";
        db.execSQL(sqltest,null);db.execSQL(sqltest2,null);
        sqltest = "INSERT INTO group (group_name) VALUES (\"group6\")";
        sqltest2 = "ALTER TABLE relation ADD group6 BOOLEAN DEFAULT 0;";
        db.execSQL(sqltest,null);db.execSQL(sqltest2,null);
        sqltest = "INSERT INTO group (group_name) VALUES (\"group7\")";
        sqltest2 = "ALTER TABLE relation ADD group7 BOOLEAN DEFAULT 0;";
        db.execSQL(sqltest,null);db.execSQL(sqltest2,null);
        sqltest = "INSERT INTO group (group_name) VALUES (\"group8\")";
        sqltest2 = "ALTER TABLE relation ADD group8 BOOLEAN DEFAULT 0;";
        db.execSQL(sqltest,null);db.execSQL(sqltest2,null);
        sqltest = "INSERT INTO group (group_name) VALUES (\"group9\")";
        sqltest2 = "ALTER TABLE relation ADD group9 BOOLEAN DEFAULT 0;";
        db.execSQL(sqltest,null);db.execSQL(sqltest2,null);

        //classify persons in group
        sqltest = "INSERT INTO relation (person_name,?,?,?) VALUES (?,1,1,1);";
        db.execSQL(sqltest,new String[] {"group1","group3","group8","boby138"});
        db.execSQL(sqltest,new String[] {"group1","group4","group5","tomi145"});
        db.execSQL(sqltest,new String[] {"group1","group2","group6","anna126"});
        db.execSQL(sqltest,new String[] {"group4","group5","group6","andy456"});
        db.execSQL(sqltest,new String[] {"group2","group3","group4","john234"});
        //---------------------------------------------------------------
        //-----------------------------------------------------------------------------
        db.execSQL(CREATE_MEMO);
        db.execSQL(CREATE_CONTACT);
        db.execSQL(CREATE_RELATION);
        db.execSQL(CREATE_GROUP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){

    }

}
