package com.example.app3;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.app3.adapter.MyAdafel;
import com.example.app3.base.BaseActivity2;
import com.example.app3.bean.Banbean;
import com.example.app3.call.CallCall;
import com.example.app3.contract.MainContract2;
import com.example.app3.fragment.BlankFragment;
import com.example.app3.fragment.HomeFragment;
import com.example.app3.presenter.PreSenterCall;
import com.example.app3.presenter.PresenterBan;
import com.example.app3.presenter.PresenterImiBan;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ProtectMainActivity extends BaseActivity2<PresenterImiBan> implements MainContract2.IViewsBan {
  private Banner banner_image;
  private TabLayout tab_main;
  private ViewPager vap_main;
  private ArrayList<Banbean.BannerlistDTO> list;
    private ArrayList<Fragment> list1;
    private BlankFragment blankFragment;
    private HomeFragment homeFragment;
    private MyAdafel myAdafel;

    @Override
    protected int getDataId() {
        return R.layout.activity_protect_main;
    }

    @Override
    protected void initData() {
        presenter.Result();
    }


    @Override
    protected void initView() {
        banner_image=findViewById(R.id.banner_image);
        tab_main=findViewById(R.id.tab_main);
        vap_main=findViewById(R.id.vap_main);
        blankFragment = new BlankFragment();
        homeFragment = new HomeFragment();
        list1 = new ArrayList<>();
        list1.add(blankFragment);
        list1.add(homeFragment);
        myAdafel = new MyAdafel(getSupportFragmentManager(), list1);
        vap_main.setAdapter(myAdafel);
        tab_main.setupWithViewPager(vap_main);
        tab_main.getTabAt(0).setText("学校新闻");
        tab_main.getTabAt(1).setText("班级成绩查询");

    }

    @Override
    protected PresenterImiBan getPresenter() {

        return new PresenterImiBan(this);
    }

    @Override
    public void getDataModelView(Banbean banbean) {
        list = new ArrayList<>();
        List<Banbean.BannerlistDTO> bannerlist = banbean.getBannerlist();
        list.addAll(bannerlist);
        banner_image.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Banbean.BannerlistDTO ba= (Banbean.BannerlistDTO) path;
                        Glide.with(context).load(ba.getImageurl()).into(imageView);
                    }
                }).start();
    }

    @Override
    public void no(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}