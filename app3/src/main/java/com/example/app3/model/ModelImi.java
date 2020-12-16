package com.example.app3.model;

import com.example.app3.contract.MaintContract;

public class ModelImi implements MaintContract.IModel {
    //接口
    private MaintContract.IPresenter presenter;

    public ModelImi(MaintContract.IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void model() {

        presenter.per("登录成功");
    }
}
