package com.example.app2.contract;

public class MainContract {
    //model
    public interface IModel{
        void modeLog();


    }
    //presenter
    public interface  IPresenter{
        void preLog(String name,String pass);

        void preResult(String error);

    }
    //view
    public interface IView{
        //
        String getName();

        String getPass();

        //结果
        void Result(String string);
    }
}
