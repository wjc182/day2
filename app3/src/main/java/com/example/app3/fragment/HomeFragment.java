package com.example.app3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app3.R;
import com.example.app3.adapter.Inforadafel2;
import com.example.app3.api.MyServier;
import com.example.app3.bean.JavaBean;
import com.example.app3.bean.RewBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {
    private FragmentActivity activity;
    private RecyclerView rew;
    private ArrayList<RewBean.StudenlistDTO> list;
    private Inforadafel2 inforadafel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServier.banUrl)
                .build()
                .create(MyServier.class)
                .rew()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RewBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull RewBean rewBean) {
                        List<RewBean.StudenlistDTO> studenlist = rewBean.getStudenlist();
                        list.addAll(studenlist);
                        inforadafel.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void initView(View inflate) {
        rew = inflate.findViewById(R.id.rew_home);
        rew.setLayoutManager(new LinearLayoutManager(activity));
        //
        list = new ArrayList<>();
        inforadafel = new Inforadafel2(activity, list);
        rew.setAdapter(inforadafel);
    }
}