package com.example.fmproject_1;

import android.content.Intent;
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


        Mydb =new FMOrderdb(this);

        eId=(EditText) findViewById(R.id.e_id);
        eLocation=(EditText) findViewById(R.id.e_location);
        eBuilding=(EditText) findViewById(R.id.e_building);
        eContact=(EditText) findViewById(R.id.e_contact);
        eTel=(EditText) findViewById(R.id.e_tel);
        eDescription=(EditText) findViewById(R.id.e_description);
        btUpdate=(Button)findViewById(R.id.btn_update);
        btDel=(Button)findViewById(R.id.btn_del);
        btHome=(Button)findViewById(R.id.btn_home);

        Home();
        OrderUpdate();
        OrderDel();


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

        // see youtube android Studio tutorial-35- using where clause with Sqlitedatabase

    }

    // call and run update method for update repair record
    public void OrderUpdate()
    {
        btUpdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                boolean isUpdated=Mydb.updateOrder(eId.getText().toString(),
                        eLocation.getText().toString(),
                        eBuilding.getText().toString(),
                        eContact.getText().toString(),
                        eTel.getText().toString(),
                        eDescription.getText().toString());

                if (isUpdated =true) {
                    Toast.makeText(detailOrder.this, "order updated", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(detailOrder.this, "order failure created", Toast.LENGTH_LONG).show();
            }
        });
    }
    // call and run update method for update repair record
    public void OrderDel()
    {
        btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // return home page
    public void Home(){
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(detailOrder.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }
}

