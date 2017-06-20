package com.example.a.t04_excustomlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] ArrList = {"튤립:노란색", "꽃:빨간색","산:갈색", "수국화:초록색", "해파리:파란색","코알라:회색",
    "성:흰색","펭귄:남색"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Mydata> list = new ArrayList<>();


        for(int i=0; i<ArrList.length; i++){
            String[] str = ArrList[i].split(":");
            String s1 = str[0];
            String s2 = str[1];
            int icon;
            if(i%8 == 0){
                icon = R.drawable.a0;
            }else if(i%8 == 1){
                icon = R.drawable.a1;
            }else if(i%8 == 2){
                icon = R.drawable.a2;
            }else if(i%8 == 3){
                icon = R.drawable.a3;
            }else if(i%8 == 4){
                icon = R.drawable.a4;
            }else if(i%8 == 5){
                icon = R.drawable.a5;
            }else if(i%8 == 6){
                icon = R.drawable.a6;
            }else{
                icon = R.drawable.a7;
            }
            Mydata data = new Mydata(s1, s2, icon);
            list.add(data);
        }
        ListView listview = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, R.layout.item_row,list);
        listview.setAdapter(adapter);
    }
}
