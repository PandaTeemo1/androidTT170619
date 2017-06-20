package com.example.a.t02_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int myRequest = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onBtnClick(View view){
        Intent intent = new Intent(MainActivity.this, MyActivity.class);
        intent.putExtra("myValue", "Hello World");
        intent.putExtra("secondValue", 123);
        startActivity(intent);

        startActivityForResult(intent, myRequest);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == myRequest){
            if(resultCode == RESULT_OK){
                String res = data.getStringExtra("myResult");
                Toast.makeText(this, "res "+res, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
