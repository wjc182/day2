package com.example.p7day02.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.p7day02.base.BaseActivity;
import com.example.p7day02.contract.MainContract;
import com.example.p7day02.presenter.PresenterView;

public class MainActivity2 extends BaseActivity<PresenterView> implements MainContract.IMainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getlayoutID() {
        return 0;
    }

    @Override
    public PresenterView getPresenter() {
        return new PresenterView(this);
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUserPass() {
        return null;
    }

    @Override
    public void getLoginData(String string) {

    }
}