package com.aksy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;


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
                Toast.makeText(MainActivity.this, "aaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void doubleClick(MotionEvent event) {
                LikeAfterAnimator likeAfterAnimator = new LikeAfterAnimator(MainActivity.this);
                likeAfterAnimator.doublesClick(relativeLayout, event);
            }
        }));
    }


}
