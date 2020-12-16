package com.example.app3.presenter;

import com.example.app3.bean.Banbean;
import com.example.app3.bean.JavaBean;
import com.example.app3.call.CallCall;
import com.example.app3.contract.MainContract2;
import com.example.app3.model.ModelBan;
import com.example.app3.model.ModelImlBan;

public class PresenterImiBan implements MainContract2.IPresenterBan, CallCall {

    private final ModelImlBan modelImlBan;
    private MainContract2.IViewsBan iViewsBan;

    public PresenterImiBan(MainContract2.IViewsBan iViewsBan) {
        this.iViewsBan = iViewsBan;
        modelImlBan = new ModelImlBan();
    }


    @Override
    public void ok(Banbean banbean) {
        iViewsBan.getDataModelView(banbean);
    }

    @Override
    public void no(String error) {
        iViewsBan.no(error);
    }


    @Override
    public void Result() {
        modelImlBan.getDataModel(this);
    }
}
