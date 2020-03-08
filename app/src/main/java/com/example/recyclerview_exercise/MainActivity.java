package com.example.recyclerview_exercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    int[] numbers = new int[1000];;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i<1000; i++) {
            numbers[i] = i+1;
        }

        recyclerView = findViewById(R.id.recyclerview);

        MyAdapter myAdapter = new MyAdapter(this, numbers);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
