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

public class Inforadafel extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<JavaBean.NewsDTO> list;

    public Inforadafel(Context context, ArrayList<JavaBean.NewsDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rew_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder v= (ViewHolder) holder;
        JavaBean.NewsDTO newsDTO = list.get(position);
        v.content.setText(newsDTO.getContent());
        v.title.setText(newsDTO.getTile());
        Glide.with(context).load(newsDTO.getImageUrl()).into(v.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private  ImageView image;
        private  TextView title;
        private TextView content;

        public ViewHolder(@NonNull View view) {
            super(view);
             image = view.findViewById(R.id.rew_image);
             title = view.findViewById(R.id.rew_title);
             content = view.findViewById(R.id.rew_content);
        }
    }
}
