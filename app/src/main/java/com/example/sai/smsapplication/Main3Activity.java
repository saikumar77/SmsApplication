package com.example.sai.smsapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dbHandler = new MyDBHandler(this,null,null,1);
        readSMS();
        ArrayList<UserMessages> al = dbHandler.msgtoString();
        UserMessages[] array = al.toArray(new UserMessages[0]);
        ListAdapter listAdapter = new CustomAdaptor(this,array);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(listAdapter);
    }

    private void readSMS(){
        dbHandler = new MyDBHandler(this,null,null,1);
        UserMessages userMessages = new UserMessages();
        Uri inbox = Uri.parse("content://sms/");
        String[] reqcolums = new String[] {"_id","address","body","date"};
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(inbox,reqcolums,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("_id")) != null){
                userMessages.set_mobileNo(c.getString(c.getColumnIndex("address")));
                userMessages.set_message(c.getString(c.getColumnIndex("body")));
                userMessages.set_time(c.getString(c.getColumnIndex("date")));
            }
            dbHandler.addMessage(userMessages);
        }
    }

}
