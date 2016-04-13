package com.example.memo;

/**
 * Created by ccccc on 2016/4/12.
 */
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.R;


public class MemoCursorAdapter extends CursorAdapter {

    public MemoCursorAdapter(Context context,Cursor cursor,int flags){
        super(context,cursor,0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.item_memo,parent,false);
    }

    @Override
    public void bindView(View view,Context context,Cursor cursor){
        TextView title = (TextView) view.findViewById(R.id.memo_title);
        TextView content = (TextView) view.findViewById(R.id.memo_content);
        TextView date = (TextView) view.findViewById(R.id.memo_d_day);

        String sqltitle = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        String sqlcontent = cursor.getString(cursor.getColumnIndexOrThrow("content"));
        String sqldate = cursor.getString(cursor.getColumnIndexOrThrow("d_day"));

        title.setText(sqltitle);
        content.setText(sqlcontent);
        date.setText(sqldate);

    }
}
