package com.example.b10709043_hw2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {
    private Cursor cursor;
    private Context context;
    public MyAdapter(Context context, Cursor cursor){
        this.cursor = cursor;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.cursor.getCount();
    }
    class myViewHolder extends RecyclerView.ViewHolder{
        TextView t1 ,t2;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            this.t1 = itemView.findViewById(R.id.tv1);
            this.t2 = itemView.findViewById(R.id.tv2);
        }
    }
}
