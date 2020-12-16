package com.example.app3.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T> extends AppCompatActivity {
  private T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getDataId());
        if(presenter==null){
            presenter=getPresenter();
        }

        initView();
    }

    protected abstract int getDataId();



    protected abstract void initView();

    protected abstract T getPresenter();

}
