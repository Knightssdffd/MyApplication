package com.aksy.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

/**
 * @Description TODO
 * @Author 幻忧
 * @Date 2020/8/8 10:18
 */

public class LikeAfterAnimator {
    private Context mContext;
    float[] num = {-30, -20, 0, 20, 30};//随机心形图片角度
    private ImageView imageView;
    private AnimatorSet animatorSet;

    public LikeAfterAnimator(Context context) {
        this.mContext = context;

    }

    public void doublesClick(RelativeLayout view, MotionEvent event) {
        imageView = new ImageView(mContext);
        animatorSet = new AnimatorSet();
        animatorSet.play(scale(imageView, "scaleX", 2f, 0.9f, 100, 0))
                .with(scale(imageView, "scaleY", 2f, 0.9f, 100, 0))
                .with(rotation(imageView, 0, 0, num[new Random().nextInt(4)]))
                .with(alpha(imageView, 0, 1, 100, 0))
                .with(scale(imageView, "scaleX", 0.9f, 1, 50, 150))
                .with(scale(imageView, "scaleY", 0.9f, 1, 50, 150))
                .with(translationY(imageView, 0, -600, 800, 400))
                .with(alpha(imageView, 1, 0, 300, 400))
                .with(scale(imageView, "scaleX", 1, 3f, 700, 400))
                .with(scale(imageView, "scaleY", 1, 3f, 700, 400));

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(300, 300);
        params.leftMargin = (int) event.getX() - 150;
        params.topMargin = (int) event.getY() - 300;
        imageView.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.icon_home_like_after));
        imageView.setLayoutParams(params);
        view.addView(imageView);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.removeViewInLayout(imageView);
            }
        });
    }



    public static ObjectAnimator scale(View view, String propertyName, float from, float to, long time, long delayTime) {
        ObjectAnimator translation = ObjectAnimator.ofFloat(view, propertyName, from, to);
        translation.setInterpolator(new LinearInterpolator());
        translation.setStartDelay(delayTime);
        translation.setDuration(time);
        return translation;
    }

    public static ObjectAnimator rotation(View view, long time, long delayTime, float... values) {
        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, "rotation", values);
        rotation.setDuration(time);
        rotation.setStartDelay(delayTime);
        rotation.setInterpolator(input -> input);
        return rotation;
    }

    public static ObjectAnimator alpha(View view, float from, float to, long time, long delayTime) {
        ObjectAnimator translation = ObjectAnimator.ofFloat(view, "alpha", from, to);
        translation.setInterpolator(new LinearInterpolator());
        translation.setStartDelay(delayTime);
        translation.setDuration(time);
        return translation;
    }

    public static ObjectAnimator translationY(View view, float from, float to, long time, long delayTime) {
        ObjectAnimator translation = ObjectAnimator.ofFloat(view, "translationY", from, to);
        translation.setInterpolator(new LinearInterpolator());
        translation.setStartDelay(delayTime);
        translation.setDuration(time);
        return translation;
    }

}
