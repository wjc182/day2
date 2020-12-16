package com.example.app3.presenter;

import com.example.app3.bean.JavaBean;
import com.example.app3.call.CallCall2;
import com.example.app3.contract.MainContract2;
import com.example.app3.model.ModelJava;

public class PresenterJava implements MainContract2.IPresenterBan, CallCall2 {
    private final ModelJava modelJava;
    private MainContract2.IViewJava iViewJava;

    public PresenterJava(MainContract2.IViewJava iViewJava) {
        this.iViewJava = iViewJava;
        modelJava = new ModelJava();
    }

    @Override
    public void ok(JavaBean javaBean) {
        iViewJava.getModelJava(javaBean);
    }

    @Override
    public void no(String error) {
        iViewJava.no(error);
    }

    @Override
    public void Result() {
        modelJava.getJava(this);
    }
}
