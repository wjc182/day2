package com.example.app1.presenter;

import com.example.app1.contract.MainContract;
import com.example.app1.model.ModelView;

public class PresenterView  implements MainContract.IPresenter {
    private final ModelView modelView;
    //view
    private MainContract.IView iView;

    public PresenterView(MainContract.IView iView) {
        this.iView = iView;
        modelView = new ModelView(this);
    }

    @Override
    public void ok(String name, String pass) {
        modelView.getModel();
    }

    @Override
    public void getPreResult(String string) {
        iView.getViewResult(string);
    }
}
