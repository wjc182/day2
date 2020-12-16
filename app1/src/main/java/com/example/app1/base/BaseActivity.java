package com.example.app1.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app1.R;

public abstract  class BaseActivity<T> extends AppCompatActivity {
    //内容
   public T presenterView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //上下文
        setContentView(getView());

        if (presenterView==null){
            //抽象方法
            presenterView=getPresenter();
        }
        //准备数据
        initData();
        initView();
    }

    protected abstract T getPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getView();
}
