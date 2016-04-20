package com.example.memo;

/**
 * Created by ccccc on 2016/4/12.
 */
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.R;

import java.util.ArrayList;
import java.util.HashMap;


public class MemoActivity extends ListActivity implements android.view.View.OnClickListener {

    private Button btnAdd,btnGetAll;
    private TextView memo_Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this,MemoDetail.class);
            intent.putExtra("memo_Id",0);
            startActivity(intent);

        }else {

            MemoRepo repo = new MemoRepo(this);

            ArrayList<HashMap<String, String>> memoList =  repo.getStudentList();
            if(memoList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        memo_Id = (TextView) view.findViewById(R.id.memo_Id);
                        String memoId = memo_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),MemoDetail.class);
                        objIndent.putExtra("memo_Id", Integer.parseInt( memoId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( MemoActivity.this,memoList,
                        R.layout.memo_add, new String[] { "_id","title","d_day"},
                        new int[] {R.id.memo_Id, R.id.memo_title,R.id.memo_d_day});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this, "No student!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
