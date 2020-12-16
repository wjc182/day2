package com.example.app1.model;

import com.example.app1.contract.MainContract;

public class ModelView implements MainContract.IModel {
    //p层接口传递数据
    private MainContract.IPresenter presenter;

    public ModelView(MainContract.IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getModel() {
        presenter.getPreResult("登录成功");
    }
}
