package com.example.fmproject_1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fmproject_1.Adapters.MyAdapter;
import com.example.fmproject_1.Model.workOrder;

import java.util.ArrayList;

public class read extends AppCompatActivity
    {

        FMOrderdb Mydb;
        ListView orderlist;
       // EditText eSearch;
        //Button btnSearch;
        //Button btnHome;
        ArrayList<workOrder> arrayList;
        MyAdapter myAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_read);

            orderlist=(ListView) findViewById(R.id.orderlistview);
            //btnSearch = (Button) findViewById(R.id.search);
          //  eSearch=findViewById(R.id.search_order);
            Mydb = new FMOrderdb(this);
            arrayList=new ArrayList<>(); // create Arraylist object

            displayOrder();

    }

      public void displayOrder()
      {
        arrayList=Mydb.getAllData();
        myAdapter=new MyAdapter(this,arrayList);
        orderlist.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

      }

    }

