package com.example.app3.presenter;

import com.example.app3.bean.Banbean;
import com.example.app3.call.CallCall;
import com.example.app3.model.ModelBan;

public class PresenterBan implements PreSenterCall, CallCall {
    private final ModelBan modelBan;
    private CallCall callCall;

    public PresenterBan(CallCall callCall) {
        this.callCall = callCall;
        modelBan = new ModelBan();
    }

    @Override
    public void pre() {
        modelBan.modelCall(this);
    }

    @Override
    public void ok(Banbean banbean) {
        callCall.ok(banbean);
    }

    @Override
    public void no(String error) {

    }
}
