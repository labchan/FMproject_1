package com.example.fmproject_1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fmproject_1.Model.workOrder;

public class detailOrder extends AppCompatActivity {

    FMOrderdb Mydb;
    workOrder order;
    TextView elocation, ebuilding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        Bundle extras = getIntent().getExtras();
        String eid = extras.getString("value");
        Toast.makeText(getApplicationContext(), "order no.:"+eid,Toast.LENGTH_LONG).show();

      /* int i = Integer.parseInt(eid);
       Mydb = new FMOrderdb(this);
       order =Mydb.getorder(i);

        String location=order.getLocation();
        String building=order.getBuilding();

        elocation=(TextView) findViewById(R.id.elocation);
        ebuilding=(TextView) findViewById(R.id.ebuilding);

        elocation.setText(location);
        ebuilding.setText(building);

        //Toast.makeText(getApplicationContext(), (eid + location +building), Toast.LENGTH_LONG).show();
      // Toast.makeText(getApplicationContext(), "buidling" + building, Toast.LENGTH_LONG).show();

        // see youtube android Studio tutorial-35- using where clause with Sqlitedatabase
       */
    }
}

