package com.example.app3.presenter;

import com.example.app3.contract.MaintContract;
import com.example.app3.model.ModelImi;

public class PresenterImi implements MaintContract.IPresenter {
    private final ModelImi modelImi;
    private MaintContract.IView view;

    public PresenterImi(MaintContract.IView view) {
        this.view = view;
        modelImi = new ModelImi(this);
    }

    @Override
    public void Result(String name, String pass) {
        modelImi.model();
    }

    @Override
    public void per(String string) {
        view.no(string);
    }
}
