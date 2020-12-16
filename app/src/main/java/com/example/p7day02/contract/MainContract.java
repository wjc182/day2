package com.example.p7day02.contract;

public class MainContract {
    //model接口
    public interface IMainModel{
        void getLogData();
    }
    //presenter接口
    public interface IMainPresenter{
        //登陆数据
        void log(String name,String pass);
        //登陆结果
        void loginResult(String string);
    }
    //view 接口
    public interface IMainView{
        //账号
        String getUserName();
        //密码
        String getUserPass();
        //结果
        void getLoginData(String string);
    }
}
