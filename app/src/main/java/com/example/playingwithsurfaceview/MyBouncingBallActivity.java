package com.example.playingwithsurfaceview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MyBouncingBallActivity extends AppCompatActivity {

    // A new class extending from SurfaceView
    public static MyBouncingBallSurfaceView myBouncingBallSurfaceView; // (*)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bouncing_ball);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myBouncingBallSurfaceView = new MyBouncingBallSurfaceView(this);
        setContentView(myBouncingBallSurfaceView);
    }
}
