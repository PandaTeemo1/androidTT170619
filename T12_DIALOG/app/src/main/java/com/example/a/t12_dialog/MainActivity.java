package com.example.a.t12_dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final int MYDIALOG = 100;

    @Override
    protected Dialog onCreateDialog(int id){
        if(id==MYDIALOG){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("TITLE").setMessage("MESSAGE").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){

                }
            });
            return builder.create();
        }
        return null;
    }

    public void onShowDialog(View view){
        showDialog(MYDIALOG);
    }
}
