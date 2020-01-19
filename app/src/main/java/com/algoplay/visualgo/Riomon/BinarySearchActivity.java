package com.algoplay.visualgo.Riomon;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.algoplay.visualgo.R;

import java.util.ArrayList;

public class BinarySearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<SearchItem> myitems=new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    EditText plainText;
    Button searchButton;
    boolean isStop=false;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binarysearch);
        this.setTitle("Binary Search");

        for (int i=47;i>=0;i--){
             myitems.add(new SearchItem(i));

        }

        Initialize();
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String a= plainText.getText().toString();
                //Toast.makeText(Searchingactivity.this, "button pressed"+a, Toast.LENGTH_SHORT).show();
                //adapter.notifyDataSetChanged();

                myitems.clear();
                for( int i=0;i<=47;i++){
                    myitems.add(new SearchItem(i));
                }
                counter=23;
                Callalgorithm(a);

            }
        });
    }

    private void Callalgorithm(String a) {

            final int bal = Integer.parseInt(a);
            final View v = recyclerView.getLayoutManager().findViewByPosition(counter);
            final int Val = myitems.get(counter).getNumber();

           // Toast.makeText(Searchingactivity.this, "button pressed" + Val, Toast.LENGTH_SHORT).show();
            v.setBackgroundColor(Color.GREEN);

           /* if(bal>Val)
            {
                for(int i=0;i<23;i++)
                {
                    v = recyclerView.getLayoutManager().findViewByPosition(i);
                    v.setBackgroundColor(Color.BLACK);
                }
            }*/

            if (Val==bal){

            }else{
                v.setBackgroundColor(Color.BLACK);
            final Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    counter++;
                    final View v = recyclerView.getLayoutManager().findViewByPosition(counter);
                    final int Val = myitems.get(counter).getNumber();
                    //Toast.makeText(Searchingactivity.this, "button pressed" + Val, Toast.LENGTH_SHORT).show();
                    v.setBackgroundColor(Color.GREEN);
                    if (bal!=Val){
                        v.setBackgroundColor(Color.BLACK);
                        handler.postDelayed(this,500);

                    }
                }
            },500);}



    }

    private void Initialize() {
        recyclerView=findViewById(R.id.gridrecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager=new GridLayoutManager(this,8);

        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyAdapter(myitems);
        recyclerView.setAdapter(adapter);
        plainText=findViewById(R.id.plain_text_input);
        searchButton=findViewById(R.id.search_button);


    }
}
