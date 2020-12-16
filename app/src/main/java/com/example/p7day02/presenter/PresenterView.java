package com.example.p7day02.presenter;

import com.example.p7day02.contract.MainContract;
import com.example.p7day02.model.ModelView;

public class PresenterView  implements MainContract.IMainPresenter {
  private MainContract.IMainModel iMainModel;
  private MainContract.IMainView iMainView;

    public PresenterView( MainContract.IMainView iMainView) {
        this.iMainModel = new ModelView(this);
        this.iMainView = iMainView;
    }

    @Override
    public void log(String name, String pass) {
        //准备数据
        iMainModel.getLogData();
    }

    @Override
    public void loginResult(String string) {
        //结果
        iMainView.getLoginData(string);
    }
}
