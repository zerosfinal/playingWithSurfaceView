package com.example.playingwithsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyBallSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    int radi = 50; // The radius of the circle
    // Moving the cercle
    // Initial values for the starting coordinates
    int x = 50, y = 50;
    // The thread to control the animation
    private MyAnimationThread animThread = null;

    public MyBallSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    // What are we going to draw? A circle
    public void newDraw(Canvas canvas) {
        //int width = canvas.getWidth(), high = canvas.getHeight();
        //int middleW = width / 2, middleH = high / 2;
        canvas.drawColor(Color.WHITE);
        Paint circle = new Paint();
        circle.setColor(Color.BLUE);
        circle.setStyle(Paint.Style.FILL);
        //canvas.drawCircle(middleW, middleH, radi, circle);
        canvas.drawCircle(x, y, radi, circle);
    }

    /*// Making bigger the circle
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {// Action down detected
                if (radi < 100) {
                    radi = radi + 20;
                } else radi = 10;
                break;
            }
        }
        return true;
    }*/

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: { // Action down detected
                // Getting the position of the click to move the circle to the point
                x = (int) event.getX();
                y = (int) event.getY();
                break;
            }
        }
        return true;
    }


    // Callback methods
    public void surfaceCreated(SurfaceHolder holder) {
        // To create and run the thread to control the animation
        if (animThread != null) return;
        animThread = new MyAnimationThread(getHolder());
        animThread.start(); // To run the animation
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        stopThread(); // Stop the thread
    }

    public void stopThread() {
        animThread.stop = true;
    }


    // Class definition for the animation thread
    private class MyAnimationThread extends Thread {
        public boolean stop = false;
        private SurfaceHolder surfaceHolder;

        // Constructor
        public MyAnimationThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }

        // Thread operations
        public void run() {
            while (!stop) {
                // TODO: New values for the attributes: position, colors, ...
                // New painting on the canvas
                Canvas c = null;
                try { // Getting the canvas for drawing
                    c = surfaceHolder.lockCanvas(null);
                    // Drawing into the canvas
                    synchronized (surfaceHolder) {
                        newDraw(c);
                    }
                } finally { // Showing the canvas on the screen
                    if (c != null) surfaceHolder.unlockCanvasAndPost(c);
                }
            } // while
        } // run
    } // MyAnimationThread
} // MySurfaceView



