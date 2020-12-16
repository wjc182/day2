package com.example.app2.model;

import com.example.app2.contract.MainContract;

public class ModelImi implements MainContract.IModel {
    //接口
    private MainContract.IPresenter presenterImi;

    public ModelImi(MainContract.IPresenter presenterImi) {
        this.presenterImi = presenterImi;
    }

    @Override
    public void modeLog() {
        presenterImi.preResult("成功");
    }
}
