package com.example.app1;




import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app1.base.BaseActivity;
import com.example.app1.contract.MainContract;
import com.example.app1.presenter.PresenterView;

public class MainActivity extends BaseActivity<PresenterView> implements MainContract.IView {
   private EditText name;
   private EditText pass;
   private Button login;

    @Override
    protected PresenterView getPresenter() {
        return new PresenterView(this);
    }

    @Override
    protected void initData() {
        presenterView.ok(getName(),getPass());
    }

    @Override
    protected void initView() {
        name=this.findViewById(R.id.ed_name);
        pass=this.findViewById(R.id.pass);
        login=this.findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(getName())&&!TextUtils.isEmpty(getPass())){
                    presenterView.ok(getName(),getPass());
                }
            }
        });
    }

    @Override
    protected int getView() {
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
    public void getViewResult(String string) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }
}