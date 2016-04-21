package com.example.edit;

/**
 * Created by ccccc on 2016/4/12.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.R;
import com.example.contact.ChooseContact;
import com.example.contact.Contact;
import com.example.contact.ContactActivity;


public class EditActivity extends Activity {

    private Button tt;
    private EditText editText;
    private EditText chooseTime;
    private TextView sender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        tt = (Button) findViewById(R.id.TouToSend);
        chooseTime = (EditText) findViewById(R.id.editTextTime);
        sender = (TextView) findViewById(R.id.sender);

// ************************************************************************//
//*************************************************************************//
//add the receivers begin

        sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditActivity.this, "You will choose the receivers.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditActivity.this,ChooseContact.class);
                startActivityForResult(intent, 2);
            }
        });

//add the receivers end
//****************************************************************************//
//send the message begin

        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.TouToSend:
                        AlertDialog.Builder dialog = new AlertDialog.Builder(EditActivity.this);
                        dialog.setTitle("ATTENTION");
                        dialog.setMessage("事务消息发出后您将无法撤回，您确定所有信息无误后进行发送");
                        dialog.setCancelable(true);
                        dialog.setPositiveButton("信息无误，确认发送", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(EditActivity.this, "You send it.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                        dialog.setNegativeButton("返回修改确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(EditActivity.this, "You will get back.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        dialog.show();
                        break;
                    default:
                        break;
                }
            }
        });
//send the message end
//*************************************************************************************//
//choose the time begin
        chooseTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                    {
                        Intent ct = new Intent(EditActivity.this , choosetime.class);
                        startActivityForResult(ct , 1);
                        break;
                    }
                    case MotionEvent.ACTION_MOVE:
                    {
                        //移动事件发生后执行代码的区域
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    {
                        //松开事件发生后执行代码的区域
                        break;
                    }

                    default:

                        break;
                }
                return false;
            }
        });




//choose the time end
//*****************************************************************************************//


    } // end onCreate

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    } // end function onCreateOptionsMenu


    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    } // end function onOptionsItemSelected


    @Override
    protected void onActivityResult(int requestCode , int resultCode , Intent data) {
        switch(requestCode) {
            case 1 :
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    chooseTime.setText(returnData);
                } // end if
                break;
            case 2 :
                if (resultCode == RESULT_OK){
                    String returnContact = data.getStringExtra("contact_return");
                    sender.setText(returnContact);
                }
            default:

        } // end switch
    } // end function onActivityResult







} // end class EdActivity
