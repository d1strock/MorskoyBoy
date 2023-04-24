package com.example.morskoy;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class DrawView extends SurfaceView implements SurfaceHolder.Callback {
    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }
    Draw draw;

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        draw = new Draw(getContext(),getHolder());
        draw.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        draw.requestStop();
        boolean retry = true;
        while (retry) {
            try {
                draw.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }
}
