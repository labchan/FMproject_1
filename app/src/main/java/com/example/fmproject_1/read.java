package com.example.fmproject_1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class read extends AppCompatActivity {

    FMOrderdb Mydb;
    EditText Esearch;
    Button btnHome, btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        Mydb = new FMOrderdb(this);
        Esearch = (EditText) findViewById(R.id.search);
        btnHome = (Button) findViewById(R.id.btnHome);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        ListOrder();
        ReturnHome();

    }
        public void ListOrder(){
            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor res = Mydb.getAllData();
                    if (res.getCount()==0){
                        // show message
                        showMessage ("Error", "nothign foud");
                        return ;
                    }

                    StringBuffer buffer =new StringBuffer();
                    while (res.moveToNext()){
                        buffer.append("id:"+res.getString(0)+"\n");
                        buffer.append("location:"+res.getString(1)+"\n");
                        buffer.append("building:"+res.getString(2)+"\n");
                        buffer.append("contact:"+res.getString(3)+"\n");
                        buffer.append("tel:"+res.getString(4)+"\n");
                        buffer.append("description:"+res.getString(5)+"\n\n");

                    }

                    // show all data
                    showMessage("data", buffer.toString());
                }
            });
        }

        public void showMessage (String title, String message) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.show();
    }

        public void ReturnHome(){
            btnHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(read.this, MainActivity.class );
                    startActivity(intent);
                }
            });
        }


    }

