package com.example.fmproject_1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class  create extends AppCompatActivity {

    //TextView createOrder;
    FMOrderdb Mydb;
    EditText etlocation, etbuilding, etcontact, ettel, etdescription;
    Button btnHome,btnCreate,btnPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Mydb =new FMOrderdb(this);

        etlocation=(EditText)findViewById(R.id.location);
        etbuilding=(EditText)findViewById(R.id.building);
        etcontact=(EditText)findViewById(R.id.contact);
        ettel=(EditText)findViewById(R.id.tel);
        etdescription=(EditText)findViewById(R.id.description);
        btnHome=(Button)findViewById(R.id.btnHome);
        btnCreate=(Button)findViewById(R.id.btnCreate);
        btnPhoto=(Button)findViewById(R.id.btnPhoto);
        AddOrder();
        ReturnHome();


    }

    // addOrder method
    public void AddOrder(){
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    boolean isInserted= Mydb.insertData(etlocation.getText().toString(),
                            etbuilding.getText().toString(),
                            etcontact.getText().toString(),
                            ettel.getText().toString(),
                            etdescription.getText().toString() ) ;
                    if (isInserted =true) {
                        Toast.makeText(create.this, "order created", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(create.this, "order failure created", Toast.LENGTH_LONG).show();

                    etlocation.setText("");
                    etbuilding.setText("");
                    etcontact.setText("");
                    ettel.setText("");
                    etdescription.setText("");
                }
            });
    }

    // return to home page
    public void ReturnHome(){
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(create.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }

}
