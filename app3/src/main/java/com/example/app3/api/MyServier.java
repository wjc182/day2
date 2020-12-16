package com.example.app3.api;

import com.example.app3.bean.Banbean;
import com.example.app3.bean.JavaBean;
import com.example.app3.bean.RewBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServier {
    String banUrl="http://cdwan.cn:7000/exam2003/";
    @GET("abannerlist.json")
    Observable<Banbean> ban();
   @GET("anewslist.json")
    Observable<JavaBean> javNews();
   @GET("astudent.json")
    Observable<RewBean> rew();

}
