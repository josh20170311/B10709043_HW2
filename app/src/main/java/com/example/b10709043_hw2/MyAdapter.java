package com.example.b10709043_hw2;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b10709043_hw2.myDbUtil.MyDbContact;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {
    private Cursor cursor;
    private Context context;
    private ShapeDrawable s;
    public MyAdapter(Context context, Cursor cursor, ShapeDrawable s){
        this.cursor = cursor;
        this.context = context;
        this.s = s;
    }
    public void reset(Cursor c){
        if(this.cursor != null)
            this.cursor.close();
        this.cursor = c;
        if(this.cursor != null)
            this.notifyDataSetChanged();
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
        if(!cursor.moveToPosition(position))
            return;
        String name = cursor.getString(cursor.getColumnIndex(MyDbContact.WaitList.COLUMN_NAME));
        int partySize = cursor.getInt(cursor.getColumnIndex(MyDbContact.WaitList.COLUMN_PARTY_SIZE));
        long id = cursor.getLong(cursor.getColumnIndex(MyDbContact.WaitList._ID));
        holder.t1.setText(partySize+"");

        holder.t1.setBackground(this.s);
        holder.t2.setText(name);
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView t1 ,t2;
        public  myViewHolder(@NonNull View itemView) {
            super(itemView);
            this.t1 = itemView.findViewById(R.id.tv1);
            this.t2 = itemView.findViewById(R.id.tv2);
        }
    }

    public void setColor(int color){
        this.s.getPaint().setColor(color);
        notifyDataSetChanged();
    }
}
