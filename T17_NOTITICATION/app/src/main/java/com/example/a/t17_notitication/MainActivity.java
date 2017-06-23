package com.example.a.t17_notitication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onBtnClick(View view){
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.penguins);
        Intent intent = new Intent(this, NotiActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentTitle("title");
        builder.setContentText("text");
        builder.setSubText("sub text");
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setLargeIcon(bitmap);
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);

        manager.notify(1234, builder.build());
    }
}
