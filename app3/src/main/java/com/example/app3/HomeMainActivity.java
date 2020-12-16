package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app3.base.BaseActivity;
import com.example.app3.contract.MaintContract;
import com.example.app3.presenter.PresenterImi;

public class HomeMainActivity extends BaseActivity<PresenterImi> implements MaintContract.IView {
    private EditText ed_name;
    private EditText ed_pass;
    private Button bu_login;
    private PresenterImi presenterImi;


    @Override
    protected int getDataId() {
        return R.layout.activity_home_main;
    }


    @Override
    protected void initView() {
        ed_name=findViewById(R.id.ed_name);
        ed_pass=findViewById(R.id.ed_pass);
        bu_login=findViewById(R.id.bu_login);
        bu_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getName().equals("H2003xs")&&getPass().equals("H2003")){
                        startActivity(new Intent(HomeMainActivity.this,ProtectMainActivity.class));
                }else {
                    Toast.makeText(HomeMainActivity.this, "账号密码不符合", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected PresenterImi getPresenter() {
        return new PresenterImi(this);
    }

    @Override
    public String getName() {
        return ed_name.getText().toString();
    }

    @Override
    public String getPass() {
        return ed_pass.getText().toString();
    }

    @Override
    public void no(String error) {
        Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
    }
}