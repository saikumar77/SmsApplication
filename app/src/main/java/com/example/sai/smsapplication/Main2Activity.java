package com.example.sai.smsapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main2Activity extends Activity {
    Button sendButton;
    EditText mobileNo;
    EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sendButton = (Button) findViewById(R.id.sendbutton);
        mobileNo = (EditText) findViewById(R.id.mobileNo);
        message = (EditText) findViewById(R.id.message);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private String getDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date dt = new Date();
        return df.format(dt);
    }

    private void sendMessage(){
        String number = mobileNo.getText().toString();
        String message1 = message.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number,null,message1,null,null);
            Toast.makeText(getApplicationContext(), "message sent", Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        UserMessages msgobj = new UserMessages();
        msgobj.set_message(message1);
        msgobj.set_mobileNo(number);
        msgobj.set_time(getDateTime());

    }

}
