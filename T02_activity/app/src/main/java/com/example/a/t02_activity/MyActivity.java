package com.example.a.t02_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by a on 2017-06-19.
 */

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();

        Intent intent = new Intent();
        intent.putExtra("myResult","hello result");
        setResult(RESULT_OK, intent);
    }
}
