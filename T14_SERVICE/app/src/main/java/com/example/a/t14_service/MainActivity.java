package com.example.a.t14_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyBindService bindService;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBindService.MyBinder binder = (MyBindService.MyBinder) service;
            bindService = binder.gerService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyBindService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    public void onNumberClick(View view){
        int num = bindService.getRandomNumber();
        Toast.makeText(this, "num"+ num, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
    }

    public void onStartClick(View view){
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }
    public void onStopClick(View view){
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}
