package com.algoplay.visualgo.Riomon;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.algoplay.visualgo.R;

import java.util.ArrayList;

public class  BinarySearchActivity extends AppCompatActivity {
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

        for (int i=0;i<=47;i++){
             myitems.add(new SearchItem(i));

        }

        Initialize();
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String a= plainText.getText().toString();
                //Toast.makeText(Searchingactivity.this, "button pressed"+a, Toast.LENGTH_SHORT).show();
                //adapter.notifyDataSetChanged();

                /*myitems.clear();
                for( int i=0;i<=47;i++){
                    myitems.add(new SearchItem(i));
                }
*/
                StartAlgo(a);

                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final View vv = recyclerView.getLayoutManager().findViewByPosition(Integer.parseInt(a));
                        vv.setBackgroundColor(Color.GREEN);
                    }
                },2000);


                //Callalgorithm(a);

            }
        });
    }

    private  void StartAlgo(String a){
        final int bal = Integer.parseInt(a);
        int aa=47/2;
        final int Val = myitems.get(aa).getNumber();
        final View v = recyclerView.getLayoutManager().findViewByPosition(counter);


        if (Val==bal){
            v.setBackgroundColor(Color.GREEN);
            return;
        }
        else{


            if (Val>bal){
                RunAnimation(0,aa);
            }else{
                RunAnimation(aa,47);
            }
           //  v.setBackgroundColor(Color.BLACK);
             binarySearch(0,47,bal);

        }




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

    private int  binarySearch(int low , int high, int bal){
        if (high>=1){

            int mid=low+(high-low)/2;
            if (mid==bal){
                final View v = recyclerView.getLayoutManager().findViewByPosition(mid);
              //   v.setBackgroundColor(Color.GREEN);
                return 1;
            }
            if (mid>bal){

                RemoveAnimation(mid+1,high);
                return binarySearch(low,mid-1,bal);
            }
            else{
                RemoveAnimation(low, mid-1);
                return  binarySearch(mid+1,high,bal);
            }


        }else
        { Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show();
            return -1;
        }

    }

    private  void RunAnimation(int low,int high){
        int i=low;
        for (i=low;i<high;i++){

            Handler handler=new Handler();
            final int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    final View v = recyclerView.getLayoutManager().findViewByPosition(finalI);
                    v.setBackgroundColor(Color.BLACK);

                }
            },1000);


       }


    }

    private  void RemoveAnimation(int low ,int high){
        int i=low;
        for (i=low;i<high;i++){

            Handler handler=new Handler();
            final int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    final View v = recyclerView.getLayoutManager().findViewByPosition(finalI);
                    v.setBackgroundColor(getResources().getColor(R.color.fa));

                }
            },1000);


        }
    }

}
