package com.example.p7day02.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.p7day02.R;
import com.example.p7day02.base.BaseActivity;
import com.example.p7day02.contract.MainContract;
import com.example.p7day02.presenter.PresenterView;

public class MainActivity extends BaseActivity<PresenterView> implements  MainContract.IMainView {
   private EditText log_name;
   private EditText log_pass;
   private Button login;



    @Override
    protected void initData() {
        presenterView.log(getUserName(),getUserPass());
    }

    @Override
    protected void initView() {
        log_name=findViewById(R.id.log_name);
        log_pass=findViewById(R.id.log_pass);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(getUserName())&&!TextUtils.isEmpty(getUserPass())){
                    presenterView.log(getUserName(),getUserPass());
                }
            }
        });

    }

    @Override
    protected int getlayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public PresenterView getPresenter() {
        return new PresenterView(this);
    }


    @Override
    public String getUserName() {
        return log_name.getText().toString();
    }

    @Override
    public String getUserPass() {
        return log_pass.getText().toString();
    }

    @Override
    public void getLoginData(String string) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }
}