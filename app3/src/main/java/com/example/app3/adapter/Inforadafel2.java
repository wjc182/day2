package com.example.app3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app3.R;
import com.example.app3.bean.JavaBean;
import com.example.app3.bean.RewBean;

import java.util.ArrayList;

public class Inforadafel2 extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<RewBean.StudenlistDTO> list;

    public Inforadafel2(Context context, ArrayList<RewBean.StudenlistDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rew_item2, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder v= (ViewHolder) holder;
        RewBean.StudenlistDTO da = list.get(position);
        v.name.setText("姓名:     "+da.getName());
        v.content.setText("机试成绩：     "+da.getSkill());
        v.title.setText("理论成绩：     "+da.getTheory());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private  TextView name;
        private  TextView title;
        private TextView content;

        public ViewHolder(@NonNull View view) {
            super(view);
             name = view.findViewById(R.id.rew2_name);
             title = view.findViewById(R.id.rew2_title);
             content = view.findViewById(R.id.rew2_content);
        }
    }
}
