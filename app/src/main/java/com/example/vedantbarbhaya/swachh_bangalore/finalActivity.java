package com.example.vedantbarbhaya.swachh_bangalore;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class finalActivity extends AppCompatActivity {
    Button button;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        button = findViewById(R.id.FAb1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getTableData();
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("ID: "+ res.getString(0)+"\n");
                    buffer.append("Name: "+ res.getString(1)+"\n");
                    buffer.append("Phone_Number: "+ res.getString(2)+"\n");
                    buffer.append("Email: "+ res.getString(3)+"\n");
                    buffer.append("Complaint_ID: "+ res.getString(4)+"\n");
                    buffer.append("Longitude: "+ res.getString(5)+"\n");
                    buffer.append("Latitude "+ res.getString(6)+"\n");

                }
            }
        });


    }

}
