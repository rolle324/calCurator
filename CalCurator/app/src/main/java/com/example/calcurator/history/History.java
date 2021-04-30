package com.example.calcurator.history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.calcurator.R;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        //Initializing ListView
        ListView lv = findViewById(R.id.lvHistory);
        BookOfDays days = BookOfDays.getInstance();
        lv.setAdapter(new ArrayAdapter<Day>(this,
                android.R.layout.simple_expandable_list_item_1,
                days.getAllDays()));

        //Event handler for ListView onClickListener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent nextActivity = new Intent(History.this, HistoryDetails.class);
                nextActivity.putExtra("HistoryIndex",i);
                startActivity(nextActivity);
            }
        });
    }
}