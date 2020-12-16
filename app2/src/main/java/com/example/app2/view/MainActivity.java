package com.example.app2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app2.R;
import com.example.app2.base.BaseActivity;
import com.example.app2.contract.MainContract;
import com.example.app2.presenter.PresenterImi;

public class MainActivity extends BaseActivity<PresenterImi> implements MainContract.IView {

  private EditText name;
  private EditText pass;
  private Button login;
  private PresenterImi presenterImi;


    @Override
    protected void initView() {
        name=findViewById(R.id.log_name);
        pass=findViewById(R.id.log_pass);
        login=findViewById(R.id.login);
        //判断
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(getName())&&!TextUtils.isEmpty(getPass())){
                    presenterImi.preLog(getName(),getPass());
                }
            }
        });
    }

    @Override
    protected void initData() {
        presenterImi = new PresenterImi(this);
    }

    @Override
    protected PresenterImi getPresenter() {
        return new PresenterImi(this);
    }
    @Override
    protected int getDataId() {
        return R.layout.activity_main;
    }

    @Override
    public String getName() {
        return name.getText().toString();
    }

    @Override
    public String getPass() {
        return pass.getText().toString();
    }

    @Override
    public void Result(String string) {
        Toast.makeText(this, "第二次成功", Toast.LENGTH_SHORT).show();
    }
}