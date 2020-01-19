package com.algoplay.visualgo.Rakib;

import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.algoplay.visualgo.ModelClass.Algoitem;
import com.algoplay.visualgo.ModelClass.Algorithm;
import com.algoplay.visualgo.R;
import com.algoplay.visualgo.RecyclerAdapter;

import java.util.ArrayList;

public class SearchRecycler extends RecyclerView.Adapter<SearchRecycler.Viewholder> {
 ArrayList<Algoitem>myalgos;

    public SearchRecycler(ArrayList<Algoitem> myalgos) {
        this.myalgos = myalgos;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.searchingitem,parent,false);
       return  new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Algoitem temp=myalgos.get(position);
        holder.mytext.setText(temp.getItemvalue());
        holder.mycard.setBackgroundColor(temp.getColorcode());


    }

    @Override
    public int getItemCount() {
         if (myalgos.isEmpty())return 0;
         else return myalgos.size();
    }



    public class Viewholder extends RecyclerView.ViewHolder{

        public CardView mycard;
        public TextView mytext;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            mycard=itemView.findViewById(R.id.cardView2);
            mytext=itemView.findViewById(R.id.mytext);

        }
    }
}
