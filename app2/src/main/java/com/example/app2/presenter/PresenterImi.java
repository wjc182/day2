package com.example.app2.presenter;

import com.example.app2.contract.MainContract;
import com.example.app2.model.ModelImi;

public class PresenterImi implements MainContract.IPresenter {
    private final ModelImi modelImi;
    private MainContract.IView iView;

    public PresenterImi(MainContract.IView iView) {
        this.iView = iView;
        modelImi = new ModelImi(this);
    }

    @Override
    public void preLog(String name, String pass) {
        modelImi.modeLog();
    }

    @Override
    public void preResult(String error) {
        iView.Result(error);
    }
}
