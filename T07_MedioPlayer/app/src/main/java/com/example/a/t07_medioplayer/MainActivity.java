package com.example.a.t07_medioplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = null   ;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    if(mp != null){
                        mp.seekTo(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(mp!=null){
                         seekBar.setProgress(mp.getCurrentPosition());
                    }
                }
            }
        }).start();
        Button btnPl = (Button) findViewById(R.id.btnPlay);

        btnPl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String path = Environment.getExternalStorageDirectory() + "/Music/Home.mp3";
                mp = new MediaPlayer();
                try {
                    mp.setDataSource(path);
                    mp.prepare();
                    mp.start();
                    seekBar.setMax(mp.getDuration());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button btnSt = (Button) findViewById(R.id.btnStop);
        btnSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp!= null){
                    mp.stop();
                    mp.release();
                    mp = null;
                }
            }
        });
    }
}
