package com.example.a.t10_sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by a on 2017-06-21.
 */

public class TestSQLHandler {
    TestSQLOpenHelper helper;

    public TestSQLHandler(Context context){
        helper = new TestSQLOpenHelper(context, "people", null, 1);

    }
    public void insert(String name,int age, String address){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("address", address);
        db.insert("student", null, values);
    }

    public void delete(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("student", "name = ?", new String[]{name});
    }
    public void update(String name, int newAge){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", newAge);
        db.update("student", values, "name = ?", new String[]{name});
    }

    public String selectAll(){
        SQLiteDatabase db = helper.getReadableDatabase();
        String str = "";

        //String sql = "select * from student";
        //Cursor c1 = db.rawQuery();
        Cursor c = db.query("student", null, null, null, null, null, null);

        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            int age = c.getInt(c.getColumnIndex("age"));
            String address = c.getString(c.getColumnIndex("address"));

            str += "id : "+id+" name : "+name+" age : "+age+" address : "+address+"\n";
        }

        return str;
    }
}
