package com.example.app3.contract;

import com.example.app3.bean.Banbean;
import com.example.app3.bean.JavaBean;
import com.example.app3.call.CallCall;
import com.example.app3.call.CallCall2;

public class MainContract2 {
    //banner
    public interface IModelBan{
        void getDataModel(CallCall callCall);
    }

    public interface IPresenterBan{
        void Result();
    }
    public interface IViewsBan{

        void getDataModelView(Banbean banbean);

        void no(String error);
    }
   //rec
    public interface IModelJava{
        void getJava(CallCall2 callCall2);
    }

    public interface IViewJava{

        void getModelJava(JavaBean javaBean);

        void no(String error);
    }
}
