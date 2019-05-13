package com.example.fmproject_1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fmproject_1.Model.workOrder;

public class detailOrder extends AppCompatActivity {

    FMOrderdb Mydb;
    workOrder order;
    TextView eLocation, eId, eBuilding, eContact, eTel, eDescription;
    Button btUpdate,btDel, btHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        eId=(EditText) findViewById(R.id.e_id);
        eLocation=(EditText) findViewById(R.id.e_location);
        eBuilding=(EditText) findViewById(R.id.e_building);
        eContact=(EditText) findViewById(R.id.e_contact);
        eTel=(EditText) findViewById(R.id.e_tel);
        eDescription=(EditText) findViewById(R.id.e_description);
        btUpdate=(Button)findViewById(R.id.btn_update);
        btDel=(Button)findViewById(R.id.btnDel);
        btHome=(Button)findViewById(R.id.btn_home);
        


        Bundle extras = getIntent().getExtras();
        String eid = extras.getString("value");
        String elocation = extras.getString("location");
        String ebuilding = extras.getString("building");
        String econtact = extras.getString("contact");
        String etel = extras.getString("tel");
        String edescription = extras.getString("description");

        eId.setText(eid);
        eLocation.setText(elocation);
        eBuilding.setText(ebuilding);
        eContact.setText(econtact);
        eTel.setText(etel);
        eDescription.setText(edescription);

        // call and run update method for update repair record


        // see youtube android Studio tutorial-35- using where clause with Sqlitedatabase

    }
}

