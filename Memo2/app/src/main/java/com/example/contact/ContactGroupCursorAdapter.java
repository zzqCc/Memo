package com.example.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.R;

/**
 * Created by ccccc on 2016/4/10.
 */
public class ContactGroupCursorAdapter extends CursorAdapter {
    public ContactGroupCursorAdapter(Context context,Cursor cursor,int flags){
        super(context,cursor,0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.item_contact_group,parent,false);
    }

    @Override
    public void bindView(View view,Context context,Cursor cursor){
        ImageView avatar = (ImageView) view.findViewById(R.id.contact_group_avatar);
        TextView name = (TextView) view.findViewById(R.id.contact_group_name);
        //image stored in sqlite//problem to be solved
        String sqlname = cursor.getString(cursor.getColumnIndexOrThrow("group_name"));
        name.setText(sqlname);


    }
}
