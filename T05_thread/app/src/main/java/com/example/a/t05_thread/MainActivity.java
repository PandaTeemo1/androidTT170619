package com.example.a.t05_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    private static final int MY_COUNT = 100;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == MY_COUNT){
                textView.setText("count : "+msg.arg1);
            }
        }
    };

    class MyThread extends Thread{
        public void run(){
            for(int i=0; i<100; i++){
                Log.d("MyThread", "count : "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.what = MY_COUNT;
                msg.arg1 = i;
                handler.sendMessage(msg);
                //textView.setText("count: "+i);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.TV);

    }
    public void ButtonClick(View view){
        /*for(int i=0; i<100; i++){
            Log.d("MyThread", "count : "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        MyThread th = new MyThread();
        th.start();
    }
}
