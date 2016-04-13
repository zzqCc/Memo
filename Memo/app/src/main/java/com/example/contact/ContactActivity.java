package com.example.contact;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ccccc on 2016/4/13.
 */
public class ContactActivity extends Activity{
    private String[] values = new String[] { "侏儒", "人类", "暗夜精灵", "矮人", "德莱尼",
            "狼人" ,"雷雪","女巫","预言家","猎人","平民","赵一鸣","周芷茜"};
    private String[] content = new String[] { "zhuru","human","fairy","short","blare",
            "wolf","xueba","witch","forecast","hunter","citizen","dashen","xuezha"};

    private List<Contact> contactList = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        for (int i=0; i<values.length; i++){
            contactList.add(new Contact(values[i],content[i]));
        }
        ContactAdapter adapter = new ContactAdapter(
                ContactActivity.this,R.layout.item_contact,contactList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Contact fruit = contactList.get(position);
                Toast.makeText(ContactActivity.this, fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
