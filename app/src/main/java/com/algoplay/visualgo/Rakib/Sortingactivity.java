package com.algoplay.visualgo.Rakib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
      int counter=0;
      int iteratation=0;
      int count=0;
      ImageView handleview;
      ArrayList<Integer>mylist=new ArrayList<>();
      Handler myhandler=new Handler();
      TextView counterText;

      boolean isSorted=true;



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

        createSuffle();

        stepButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                String cn=String.valueOf(count);
                isSorted=true;
                counterText.setText("STEP: "+ cn);

                Log.e("PLAY","CLICKED");
                iteratation=0;
                counter=0;
                myhandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    if (counter+1<9){
                                        Log.e("DEV",counter+ ":COUNTER");
                                        Log.e("DEV", "ARRAY: "+mylist.toString());

                                        if (mylist.get(counter)>mylist.get(counter+1)){
                                            Log.e("DEV",counter+ ":EXchange");
                                            adapter.notifyItemMoved(counter,counter+1);
                                            int temp=mylist.get(counter);
                                            mylist.set(counter,mylist.get(counter+1));
                                            mylist.set(counter+1,temp);
                                            isSorted=false;
                                            counter++;
                                            myhandler.postDelayed(this,300);

                                        }else{
                                            counter++;
                                            Log.e("DEV",counter+ ": No EXchange");
                                            myhandler.postDelayed(this,300);
                                        }

                                        if (isSorted&counter==8){
                                            counterText.setText("SORTED!!!");
                                            count=0;
                                        }

                                    }else{
                                       myhandler.removeCallbacks(this);
                                    }

                                }
                            },300);

            }
        });

    }

    private void Initialize() {
        sufflebtn=findViewById(R.id.searchsufflebtn);
        stepButon=findViewById(R.id.searchstepbtn);
        playbtn=findViewById(R.id.searchplaybtn);
        handleview=findViewById(R.id.handler);
        counterText=findViewById(R.id.steptext);



        sufflebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               createSuffle();
            }
        });

    }

    private  void createSuffle(){
        setSuffleList();
        mylist.clear();
        mylist=new ArrayList<>(myset);
        myitems.clear();
        for (int i=0;i<9;i++){
            int a=mylist.get(i);
            String val=String.valueOf(a);
            myitems.add(new Algoitem(a,val,getRandomColor()));
        }
        adapter.notifyDataSetChanged();
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

    private void ExchangeView(View left, View right){
        ObjectAnimator leftanim = ObjectAnimator.ofFloat(left, "translationX",  77f);
        ObjectAnimator rightanim= ObjectAnimator.ofFloat(right,"translationX",-77);
        leftanim.setDuration(500);
        rightanim.setDuration(500);
        leftanim.start();
        rightanim.start();


    }
}
