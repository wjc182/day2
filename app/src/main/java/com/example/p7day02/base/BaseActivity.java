package com.example.p7day02.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public  abstract class BaseActivity<T> extends AppCompatActivity {
    public T presenterView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getlayoutID());

        if(presenterView==null){
            presenterView=getPresenter();
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getlayoutID();

    //抽象方法
    public abstract T getPresenter();
}
