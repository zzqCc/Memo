package com.example.memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.R;

/**
 * Created by ccccc on 2016/4/16.
 */
public class MemoDetail extends ActionBarActivity implements View.OnClickListener {

    private Button btnSave,btnDelete;
    private Button btnClose;
    private EditText etName;
    private EditText etEmail;
    private EditText etAge;
    private int _student_id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_detail);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        etName = (EditText) findViewById(R.id.etTitle);
        etEmail = (EditText) findViewById(R.id.etTime);
        etAge = (EditText) findViewById(R.id.etContent);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);

        _student_id =0;
        Intent intent = getIntent();
        _student_id =intent.getIntExtra("memo_Id", 0);
        MemoRepo repo = new MemoRepo(this);
        Memo memo = new Memo();
        memo = repo.getStudentById(_student_id);

        etAge.setText(memo.memo_content);
        etName.setText(memo.memo_title);
        etEmail.setText(memo.date);
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

    @Override
    public void onClick(View v) {
        if(v==findViewById(R.id.btnSave)){
            MemoRepo repo=new MemoRepo(this);
            Memo memo=new Memo();
            memo.date=etAge.getText().toString();
            memo.memo_content=etEmail.getText().toString();
            memo.memo_title=etName.getText().toString();
            memo.memo_ID=_student_id;

            if(_student_id==0){
                _student_id=repo.insert(memo);
                Toast.makeText(this, "New Student Insert", Toast.LENGTH_SHORT).show();
            }else{
                repo.update(memo);
                Toast.makeText(this,"Student Record updated",Toast.LENGTH_SHORT).show();
            }
        }else if (v== findViewById(R.id.btnDelete)){
            MemoRepo repo = new MemoRepo(this);
            repo.delete(_student_id);
            Toast.makeText(this, "Student Record Deleted", Toast.LENGTH_SHORT).show();
            finish();
        }else if (v== findViewById(R.id.btnClose)){
            finish();
        }
    }
}
