package com.algoplay.visualgo.Riomon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;

import com.algoplay.visualgo.R;

import java.util.ArrayList;

public class Searchingactivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<SearchItem> myitems=new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchingactivity);
        this.setTitle("Linear Search");

        for (int i=0;i<=47;i++){
             myitems.add(new SearchItem(i));

        }

        Initialize();
    }

    private void Initialize() {
        recyclerView=findViewById(R.id.gridrecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager=new GridLayoutManager(this,8);

        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyAdapter(myitems);
        recyclerView.setAdapter(adapter);


    }
}
