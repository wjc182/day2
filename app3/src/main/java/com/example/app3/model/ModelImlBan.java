package com.example.app3.model;

import com.example.app3.api.MyServier;
import com.example.app3.bean.Banbean;
import com.example.app3.call.CallCall;
import com.example.app3.contract.MainContract2;
import com.example.app3.contract.MaintContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelImlBan implements MainContract2.IModelBan {

    @Override
    public void getDataModel(CallCall callCall) {
        new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServier.banUrl)
                .build()
                .create(MyServier.class)
                .ban()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Banbean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Banbean banbean) {
                        callCall.ok(banbean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callCall.no("网络错误："+e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
