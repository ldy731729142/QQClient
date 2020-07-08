package com.example.qqclient;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView line1;
    //获得屏幕的宽度
    public static int widthPixels=0;
    MyAdapter adapter;

    private ArrayList<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //获得屏幕宽度
        Display display = getWindowManager().getDefaultDisplay();
        widthPixels = display.getWidth()-45;

        initDate();

    }

    private void initDate() {
        list.add("小明");
        list.add("小红");
        list.add("小亮");
        list.add("小花");
        adapter=new MyAdapter(MainActivity.this);
        adapter.set(list);
        line1.setAdapter(adapter);




    }

    private void initView() {
        line1 = (ListView) findViewById(R.id.line1);
    }
}