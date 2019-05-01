package com.example.fmproject_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnUpdate, btnRead, btnDel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnUpdate=(Button)findViewById(R.id.btnUpdate);
        btnRead=(Button)findViewById(R.id.btnQuery);
        btnDel=(Button)findViewById(R.id.btnDel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, create.class );
                startActivity(intent);
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, read.class );
                startActivity(intent);
            }
        });

    }
}
