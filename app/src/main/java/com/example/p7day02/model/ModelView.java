package com.example.p7day02.model;

import com.example.p7day02.contract.MainContract;

public class ModelView implements MainContract.IMainModel {

    //得到p层的接口传递数据
    private MainContract.IMainPresenter presenter;
     //构造
    public ModelView(MainContract.IMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getLogData() {

        presenter.loginResult("登录成功");
    }
}
