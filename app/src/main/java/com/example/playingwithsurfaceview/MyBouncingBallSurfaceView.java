package com.example.playingwithsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class MyBouncingBallSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    public MyBouncingBallSurfaceView(Context context) {
        super(context);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    // To paint into the canvas
    public void newDraw(Canvas canvas) {
    }

    // The thread to program the animation
    private class BouncingBallAnimationThread extends Thread {
        public BouncingBallAnimationThread(SurfaceHolder surfaceHolder) {
        }

        public void run() {
        }
    }

}
