package com.tony.dayone_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewHolderAdapter extends RecyclerView.Adapter<ViewHolderAdapter.MyViewHolder>{

    ArrayList<Users> mList;
    Context context;

    public  ViewHolderAdapter(Context context, ArrayList<Users> mlist){
        this.context = context;
        this.mList = mlist;
    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.each_user, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Users user = mList.get(position);
        holder.Tname.setText(user.getName());
        holder.Tcounty.setText(user.getCounty());
        holder.Tphone.setText(user.getPhone());
        holder.Tage.setText(user.getAge());
        holder.Temail.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView Tname, Tcounty, Tphone, Tage, Temail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Tname = itemView.findViewById(R.id.tv_name);
            Tcounty = itemView.findViewById(R.id.tv_county);
            Tphone = itemView.findViewById(R.id.tv_phone);
            Tage = itemView.findViewById(R.id.tv_age);
            Temail = itemView.findViewById(R.id.tv_email);
        }
    }
}
