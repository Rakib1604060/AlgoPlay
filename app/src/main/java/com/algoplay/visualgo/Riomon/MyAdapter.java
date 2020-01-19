package com.algoplay.visualgo.Riomon;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.algoplay.visualgo.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder> {
    List<SearchItem> myClasses;

    MyAdapter(ArrayList<SearchItem> items) {
        this.myClasses = items;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View V = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.searchitem, viewGroup, false);

        return new viewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        SearchItem item = myClasses.get(i);
        String number = String.valueOf(item.getNumber());

        viewHolder.numberText.setText(number);

    }

    @Override
    public int getItemCount() {
        if (myClasses != null) {
            return myClasses.size();
        } else
            return 0;
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        public TextView numberText;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            numberText = itemView.findViewById(R.id.mytext);
        }


    }
}