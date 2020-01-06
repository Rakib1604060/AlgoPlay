package com.algoplay.visualgo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.algoplay.visualgo.ModelClass.Algorithm;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {
   ArrayList<Algorithm>myalgorithms;
   OnClickAlog onClickAlog;

    public RecyclerAdapter(ArrayList<Algorithm> myalgorithms, OnClickAlog onClickAlog) {
        this.myalgorithms = myalgorithms;
        this.onClickAlog = onClickAlog;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycleritem,parent,false);
       return  new viewHolder(view,onClickAlog);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
         if (myalgorithms.isEmpty())
             return 0;
         else
             return myalgorithms.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView algoname;
        TextView algocreator;
        OnClickAlog onClickAlog;


        public viewHolder(@NonNull View itemView,OnClickAlog onClickAlog) {
            super(itemView);
            this.onClickAlog=onClickAlog;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }
    }

    public interface OnClickAlog{
        void onclick(Algorithm algorithm);
    }
}
