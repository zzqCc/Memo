package com.example.lx.memo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2016/4/4.
 */
public class ContactActivity extends Activity{
    private List<Contacts> contactList = new ArrayList<Contacts>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initContacts();
        ContactsAdapter adapter = new ContactsAdapter(ContactActivity.this,
                R.layout.activity_contact, contactList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
    private void initContacts() {
        Contacts apple = new Contacts("Apple", "hhh",R.mipmap.ic_launcher);
        contactList.add(apple);
        Contacts banana = new Contacts("Banana","aaa", R.mipmap.ic_launcher);
        contactList.add(banana);
    }


}
