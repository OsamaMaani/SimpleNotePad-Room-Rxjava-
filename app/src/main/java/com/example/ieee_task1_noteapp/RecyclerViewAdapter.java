package com.example.ieee_task1_noteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<DataModel> list = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         holder.tvNote.setText(list.get(position).getTitle());
         holder.tvDate.setText(list.get(position).getDateTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<DataModel> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView tvNote;
        TextView tvDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNote = itemView.findViewById(R.id.tvNote);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }

}
