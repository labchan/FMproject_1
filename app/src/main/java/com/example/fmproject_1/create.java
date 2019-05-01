package com.example.fmproject_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class  create extends AppCompatActivity {

    //TextView createOrder;
    EditText location, building, contact, tel, description;
    Button btnHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        location=(EditText)findViewById(R.id.location);
        building=(EditText)findViewById(R.id.building);
        contact=(EditText)findViewById(R.id.contact);
        tel=(EditText)findViewById(R.id.tel);
        description=(EditText)findViewById(R.id.description);
        btnHome=(Button)findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(create.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }
}
