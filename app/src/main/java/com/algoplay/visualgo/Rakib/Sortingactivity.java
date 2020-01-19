package com.algoplay.visualgo.Rakib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.algoplay.visualgo.ModelClass.Algoitem;
import com.algoplay.visualgo.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Sortingactivity extends AppCompatActivity {
      RecyclerView recyclerView;
      SearchRecycler adapter;
      RecyclerView.LayoutManager manager;
      ArrayList<Algoitem>myitems=new ArrayList<>();
      Button stepButon,playbtn,sufflebtn;
      Set<Integer>myset=new HashSet<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sortingactivity);
        setTitle("Bubble Sort");
        recyclerView=findViewById(R.id.sortrecycler);
        recyclerView.setHasFixedSize(true);
        Initialize();
        manager=new GridLayoutManager(this,9);
        recyclerView.setLayoutManager(manager);

        for (int i=0;i<9;i++){

            myitems.add(new Algoitem(i,i+"",getRandomColor()));
        }

        adapter=new SearchRecycler(myitems);
        recyclerView.setAdapter(adapter);
        stepButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = recyclerView.getLayoutManager().findViewByPosition(1);
                v.setBackgroundColor(Color.GREEN);
                ObjectAnimator animation = ObjectAnimator.ofFloat(v, "translationY",  400f);
                animation.setDuration(2000);
                animation.start();
            }
        });

    }

    private void Initialize() {
        sufflebtn=findViewById(R.id.searchsufflebtn);
        stepButon=findViewById(R.id.searchstepbtn);
        playbtn=findViewById(R.id.searchplaybtn);
        sufflebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSuffleList();
                ArrayList<Integer>mylist=new ArrayList<>(myset);
                myitems.clear();
                for (int i=0;i<9;i++){
                    int a=mylist.get(i);
                    String val=String.valueOf(a);
                    myitems.add(new Algoitem(a,val,getRandomColor()));
               }
                adapter.notifyDataSetChanged();
            }
        });

    }

    public int getRandomColor(){
        int randomInt = ThreadLocalRandom.current().nextInt(1, 7);
        int colorcode=0;
        switch (randomInt){
            case 1:
                colorcode=Color.GREEN;
                break;
            case 2:
                colorcode=Color.GRAY;
                break;
            case 3:
                colorcode=Color.MAGENTA;
                break;
            case 4:
                colorcode=Color.CYAN;
                break;
            case 5:
                colorcode=Color.WHITE;
                break;
            case 6:
                colorcode=Color.rgb(177, 100, 222);
                break;
    }
    return colorcode;
    }


    private void setSuffleList(){
        myset.clear();
        while(myset.size()<9){
            int random=ThreadLocalRandom.current().nextInt(1, 99);
            myset.add(random);
        }

    }
}
