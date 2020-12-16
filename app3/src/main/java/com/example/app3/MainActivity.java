package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
  private TextView timer;
    private Disposable subscribe;
   private ImageView iamge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=findViewById(R.id.timer);
        iamge=findViewById(R.id.image1);

        ObjectAnimator ob1 = ObjectAnimator.ofFloat(iamge, View.ROTATION, 0, 720);
        ObjectAnimator ob2 = ObjectAnimator.ofFloat(iamge, View.ALPHA, 0, 1);
        ObjectAnimator ob3 = ObjectAnimator.ofFloat(iamge, View.SCALE_Y, 1, 2);
        ObjectAnimator ob4 = ObjectAnimator.ofFloat(iamge, View.TRANSLATION_X, 0, 720,-200);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ob1,ob2,ob3,ob4);
        animatorSet.setDuration(10000);
        animatorSet.start();

        subscribe = Observable.interval(0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        int time = 3;
                        timer.setText((time - aLong) + "s");
                        if (aLong >= 3) {
                            subscribe.dispose();
                            startActivity(new Intent(MainActivity.this,HomeMainActivity.class));
                        }
                    }
                });
    }
}