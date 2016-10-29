package com.example.sai.smsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] functions = {"Send SMS", "View Chat","Upload to Drive"};
        ListAdapter funAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,functions);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(funAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String fun = String.valueOf(parent.getItemAtPosition(position));
                        chooseOperation(fun);
                    }
                }
        );
    }

    private void chooseOperation(String fun) {
        if(fun.equals("Send SMS")){
            Intent intent = new Intent(this,Main2Activity.class);
            startActivity(intent);
        } else if(fun.equals("View Chat")) {
            Intent intent2 = new Intent(this,Main3Activity.class);
            startActivity(intent2);
        }
    }
}
