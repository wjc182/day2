package com.example.app2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app2.contract.MainContract;

public abstract class BaseActivity<T> extends AppCompatActivity {
//p层拿数据
    private T presenter;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //上下文
        setContentView(getDataId());
        //传递p层给v层
        if(presenter==null){
           presenter=getPresenter();
        }
        //准备数据、
        initData();
        //布局】
         initView();
    }

    protected abstract T getPresenter();

    protected abstract void initView();

    protected abstract void initData();
    

    protected abstract int getDataId();
}
