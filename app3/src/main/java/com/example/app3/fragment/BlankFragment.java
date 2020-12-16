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
import com.example.app3.adapter.Inforadafel;
import com.example.app3.api.MyServier;
import com.example.app3.bean.Banbean;
import com.example.app3.bean.JavaBean;
import com.example.app3.call.CallCall;
import com.example.app3.contract.MainContract2;
import com.example.app3.presenter.PresenterBan;
import com.example.app3.presenter.PresenterJava;

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


public class BlankFragment extends Fragment implements CallCall, MainContract2.IViewJava {


    private FragmentActivity activity;
    private RecyclerView rew;
    private ArrayList<JavaBean.NewsDTO> list;
    private Inforadafel inforadafel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        PresenterJava presenterJava = new PresenterJava(this);
        presenterJava.Result();
    }

    private void initView(View inflate) {
        rew = inflate.findViewById(R.id.rew_ban);
        rew.setLayoutManager(new LinearLayoutManager(activity));
        //
        list = new ArrayList<>();
        inforadafel = new Inforadafel(activity, list);
        rew.setAdapter(inforadafel);
    }

    @Override
    public void ok(Banbean banbean) {
        
    }

    @Override
    public void getModelJava(JavaBean javaBean) {
        List<JavaBean.NewsDTO> news = javaBean.getNews();
        list.addAll(news);
        inforadafel.notifyDataSetChanged();
    }

    @Override
    public void no(String error) {

    }
}