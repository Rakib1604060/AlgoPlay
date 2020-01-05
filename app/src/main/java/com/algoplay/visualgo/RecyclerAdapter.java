package com.algoplay.visualgo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.algoplay.visualgo.ModelClass.Algorithm;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {
   ArrayList<Algorithm>myalgorithms;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return null;
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

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView algoname;
        TextView algocreator;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
