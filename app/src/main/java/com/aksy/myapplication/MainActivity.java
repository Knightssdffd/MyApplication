package com.aksy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = findViewById(R.id.rl);
        relativeLayout.setOnTouchListener(new OnDoubleClickListener(new OnDoubleClickListener.MyClickCallBack() {
            @Override
            public void oneClick() {
            }

            @Override
            public void doubleClick(MotionEvent event) {
                LikeAfterAnimator likeAfterAnimator = new LikeAfterAnimator(MainActivity.this);
                likeAfterAnimator.doublesClick(relativeLayout, event);
            }
        }));
    }


}
