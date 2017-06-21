package com.example.a.t08menu;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 100, 0, "hello");
        menu.add(0, 101, 0, "world");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permission[], int[] grantResults){
        switch(requestCode){
            case MY_PERMISSIONS_REQUEST: {
                if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    listFile();
                }else{
                    textView.setText("READ EXTERNAL STORAGE DENIED!!");
                }
                return;
            }
        }
    }
    private boolean checkPermisson(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            return true;
        }else{
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
            return false;
        }
    }

    static final int MY_PERMISSIONS_REQUEST = 100;

    private void listFile(){
       /* textView.setText("");
            File root = Environment.getExternalStorageDirectory();
            File[] files = root.listFiles();
            String str = "";
            for (int i = 0; i < files.length; i++) {
                str += files[i].getName() + "\n";
            }
            textView.setText(str);
            */
        textView.setText("");
        File root = Environment.getExternalStorageDirectory();
        String[] strs = root.list();
        int index = 0;
        for(int i=0; i<strs.length; i++){
            textView.append("i"+(index++)+strs[i]+"\n");
        }
        for(int i=0; i<strs.length; i++){
            textView.append("i"+(index++)+strs[i]+"\n");
        }
        for(int i=0; i<strs.length; i++){
            textView.append("i"+(index++)+strs[i]+"\n");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_test1){
            Toast.makeText(this,"item1 : ",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.menu_test2){
            if(checkPermisson()){
                listFile();
            }

        }
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId() == 100){
            Toast.makeText(this,"context1", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==101){
            Toast.makeText(this,"context2", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
