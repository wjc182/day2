package com.example.app3.contract;

public class MaintContract {
    //接口model
    public interface IModel{
     //接口 presenter
        void model();
    }
    public interface IPresenter{

        void per(String string);

    }
    //view
    public interface IView{
        String getName();

        String getPass();

        void no(String error);
    }
}
