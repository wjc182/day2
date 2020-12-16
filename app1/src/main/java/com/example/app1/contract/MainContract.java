package com.example.app1.contract;

public class
MainContract {
    //view接口
    public interface IView{

       String getName();

       String getPass();
       //结果
       void getViewResult(String string);
    }
    //presenter接口
    public interface IPresenter{
        //登录内容
        void  ok(String  name,String pass);
        //结果
        void getPreResult(String string);
    }

    //model接口
    public interface IModel {
         void getModel();
    }
}
