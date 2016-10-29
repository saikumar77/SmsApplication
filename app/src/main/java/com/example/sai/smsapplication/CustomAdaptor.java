package com.example.sai.smsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by sai on 10/29/2016.
 */

public class CustomAdaptor extends ArrayAdapter<UserMessages> {

    CustomAdaptor(Context context,UserMessages[] msgs ){
        super(context,R.layout.custom_row,msgs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customview = inflater.inflate(R.layout.custom_row, parent, false);

        UserMessages msg = getItem(position);
        TextView phoneNo = (TextView) customview.findViewById(R.id.mobileNo);
        TextView time = (TextView) customview.findViewById(R.id.time);
        TextView status = (TextView) customview.findViewById(R.id.status);
        TextView message = (TextView) customview.findViewById(R.id.message);

        phoneNo.setText(msg.get_mobileNo());
        time.setText(msg.get_time());
        status.setText(msg.get_status());
        message.setText(msg.get_message());
        return customview;
    }
    }



