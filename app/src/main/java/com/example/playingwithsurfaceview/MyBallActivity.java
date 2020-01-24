package com.example.playingwithsurfaceview;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

public class MyBallActivity extends MainMenu {

    public MyBallSurfaceView myBallSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ball);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myBallSurfaceView = new MyBallSurfaceView(this);
        setContentView(myBallSurfaceView);
    }

}
