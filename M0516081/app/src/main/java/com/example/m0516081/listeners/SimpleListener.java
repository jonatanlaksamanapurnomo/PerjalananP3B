package com.example.m0516081.listeners;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class SimpleListener extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d("d", e1.getX() + " " + e1.getY());
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}
