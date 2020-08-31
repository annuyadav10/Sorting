package com.example.lenovo.sorting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private  List<Model> listdata;
    Context context;
    public Adapter(List<Model> listdata, Context context)
    {
        this.listdata=listdata;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.user_list,parent,false);
        return new ViewHolder(view) ;
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.username.setText(listdata.get(position).getName());
     holder.id.setText(listdata.get(position).getid());
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       public TextView username,id;
       public RelativeLayout relativeLayout;
       public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view=itemView;
           username=itemView.findViewById(R.id.username);
           id=itemView.findViewById(R.id.id);
           relativeLayout=itemView.findViewById(R.id.relativelayout);

        }
    }
}
