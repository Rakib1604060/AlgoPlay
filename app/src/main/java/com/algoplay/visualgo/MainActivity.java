package com.algoplay.visualgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.algoplay.visualgo.Rakib.Insertion;
import com.algoplay.visualgo.Rakib.Sortingactivity;
import com.algoplay.visualgo.Riomon.BinarySearchActivity;
import com.algoplay.visualgo.Riomon.Searchingactivity;
import com.algoplay.visualgo.Sharmin.QueueActivity;
import com.algoplay.visualgo.Sharmin.Stackactivity;

public class MainActivity extends AppCompatActivity {
    CardView stack,search,sort;
    ListView mylist;
    String [] listItem= new String[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialize();
        //setClickListener();

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
    /*    search=findViewById(R.id.searching);
        sort=findViewById(R.id.sorting);
        stack=findViewById(R.id.stack);*/

    mylist=findViewById(R.id.listview);
    listItem= new String[]{"Stack","Stack Details", "Queue","Queue Details", "Bubble Sort","Bubble Sort Details", "Insertion Sort","Insertion Sort Details", "Linear Search","Linear Search Details", "Binary Search","Binary Search Details"};
    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
    mylist.setAdapter(adapter);

    mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

         switch (i){

             case 0:
                 startActivity(new Intent(MainActivity.this, Stackactivity.class));
                 break;
             case 1:
                 Intent intent=new Intent(MainActivity.this, Details.class);
                 intent.putExtra("EXTRA",getResources().getString(R.string.stack));
                 startActivity(intent);
                 break;
             case 2:
                 startActivity(new Intent(MainActivity.this, QueueActivity.class));
                 break;
             case 3:
                Intent  intentt=new Intent(MainActivity.this, Details.class);
                 intentt.putExtra("EXTRA",getResources().getString(R.string.queue));
                 startActivity(intentt);
                 break;
             case 4:
                 startActivity(new Intent(MainActivity.this, Sortingactivity.class));
                 break;
             case 5:
                  Intent inten=new Intent(MainActivity.this, Details.class);
                 inten.putExtra("EXTRA",getResources().getString(R.string.bubble));
                 startActivity(inten);
                 break;
             case 6:
                 startActivity(new Intent(MainActivity.this, Insertion.class));
                 break;
             case 7:
                Intent intet=new Intent(MainActivity.this, Details.class);
                 intet.putExtra("EXTRA",getResources().getString(R.string.insertion));
                 startActivity(intet);
                 break;
             case 8:
                 startActivity(new Intent(MainActivity.this, Searchingactivity.class));
                 break;
             case 9:
                 Intent intnt=new Intent(MainActivity.this, Details.class);
                 intnt.putExtra("EXTRA",getResources().getString(R.string.linear));
                 startActivity(intnt);
                 break;
             case 10:
                 startActivity(new Intent(MainActivity.this, BinarySearchActivity.class));
                 break;
             case 11:
                Intent inent=new Intent(MainActivity.this, Details.class);
                 inent.putExtra("EXTRA",getResources().getString(R.string.binary));
                 startActivity(inent);
                  break;




         }

        }
    });


    }
}
