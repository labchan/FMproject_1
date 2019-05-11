package com.example.fmproject_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fmproject_1.Model.workOrder;

import java.util.ArrayList;

public class FMOrderdb extends SQLiteOpenHelper {

    public static final String Database_Name="FMdb";// database name
    public static final String Table_Name="RMorder"; // table name
    public static final int Database_Version= 1;
    public static final String eid="id";
    public static final String elocation="location";
    public static final String ebuilding="building";
    public static final String econtact="contact";
    public static final String etel="tel";
    public static final String edesc="description";
    /*private static final String Create_table=" create table "+Table_Name+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "location TEXT, site TEXT, contact TEXT, tel TEXT, description TEXT)";*/

   /* public static final String Create_table="create table " +Table_Name +"( id INTERGER PRIMARY KEY AUTOINCREMENT,
            location VARCHAR(15), building VARCHAR(15), contact VARCHAR(15), tel VARCHAR(15),
            edesc VARCHAR(15));";*/



    // constructor construct database FMdb
    public FMOrderdb(Context context) {
        super(context,Database_Name, null,1);
    }

    // CREATE A TABLE
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table "+Table_Name+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, location TEXT, building TEXT, contact TEXT, tel TEXT, description TEXT)");
       // db.execSQL(Create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " +Table_Name);
       // onCreate(db);

    }

    // insert data method
    public boolean insertData(String location, String building, String contact, String tel, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contenValues=new ContentValues();
        contenValues.put(elocation, location);
        contenValues.put(ebuilding, building);
        contenValues.put(econtact, contact);
        contenValues.put(etel, tel);
        contenValues.put(edesc, description);

        // checking any record be insert
        long result = db.insert(Table_Name, null, contenValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    // list & display data method
    /*public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from " +Table_Name, null);
        return res;

    } */

    // create mehtod to view data
   /* public Cursor viewData()
    {
        SQLiteDatabase db =this.getReadableDatabase();
        String query = "select *from " +Table_Name;
        Cursor cursor=db.rawQuery(query, null);
        return cursor;

    } */

    public ArrayList<workOrder> getAllData()
    {
        ArrayList<workOrder> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select *from " + Table_Name;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext())
        {
            int id=cursor.getInt(0);
            String location=cursor.getString(1);
            String building=cursor.getString(2);
            String descritpion=cursor.getString(5);

            workOrder workorder =new workOrder(id, location, building, null,null, descritpion);

            arrayList.add(workorder);
        }
            return arrayList;

    }

    // get specific workorder data
    public workOrder getorder(int id) {

        workOrder workorder = new workOrder();
        SQLiteDatabase db = this.getReadableDatabase();

        // specify the columns to be fetched
        String[] columns = {eid, elocation, ebuilding, econtact, etel, edesc};

        // select condition
        String selection = eid + "=?";

        // Arguments for selection
        String[] selectionArgs = {String.valueOf(eid)};

        //Cursor res = db.rawQuery(queryorder, null);
        Cursor res = db.query(Table_Name, columns, selection, selectionArgs, null, null, null);

        if (null != res) {
            res.moveToFirst();
            workorder.setId((Integer.parseInt(res.getString(0))));
            workorder.setLocation(res.getString(1));
            workorder.setBuilding(res.getString(2));
            workorder.setContact(res.getString(3));
            workorder.setTel(res.getString(4));
            workorder.setDescription(res.getString(5));

        }

        db.close();
        return workorder;

    }

    // update data method
    public boolean updateOrder(String id, String location, String building, String contact, String tel, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(eid,id);
        contentValues.put(elocation,location);
        contentValues.put(ebuilding,building);
        contentValues.put(econtact,contact);
        contentValues.put(etel,tel);
        contentValues.put(edesc,description);
        db.update(Table_Name, contentValues, "ID = ?",new String[] { id });
        return true;
    }
    // delete data method

}
