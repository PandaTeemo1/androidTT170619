package com.example.a.t10_sqllite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestSQLHandler dbhandler = new TestSQLHandler(this);
        dbhandler.insert("kim", 20, "seoul");
        dbhandler.insert("lee", 21, "붓산");
        dbhandler.update("kim", 29);

        String str = dbhandler.selectAll();

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(str);
    }
}
