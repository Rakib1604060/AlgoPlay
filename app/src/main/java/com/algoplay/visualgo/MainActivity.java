package com.algoplay.visualgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.algoplay.visualgo.Rakib.Sortingactivity;
import com.algoplay.visualgo.Riomon.Searchingactivity;
import com.algoplay.visualgo.Sharmin.Stackactivity;

public class MainActivity extends AppCompatActivity {
    CardView stack,search,sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialize();
        setClickListener();

    }

    private void setClickListener() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Searchingactivity.class));

            }
        });
        stack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Stackactivity.class));

            }
        });


        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Sortingactivity.class));

            }
        });



    }

    private void Initialize() {
        search=findViewById(R.id.searching);
        sort=findViewById(R.id.sorting);
        stack=findViewById(R.id.stack);

    }
}
