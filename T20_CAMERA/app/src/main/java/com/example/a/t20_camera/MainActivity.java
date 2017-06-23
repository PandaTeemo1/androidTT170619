package com.example.a.t20_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private static final int TAKE_PHOTE = 100;
    public void onBtnClick(View view){
        String path = Environment.getExternalStorageDirectory()+"/t20.jpg";
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path)));

        startActivityForResult(intent, TAKE_PHOTE);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent Data){
        if(requestCode == TAKE_PHOTE){
            if(resultCode == RESULT_OK){
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Bitmap bitmap = (Bitmap) Data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
                 }
        }
    }
}
