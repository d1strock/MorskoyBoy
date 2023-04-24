package com.example.morskoy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.method.Touch;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Draw extends Thread{
    GameActivity gameActivity;
    SurfaceHolder surfaceHolder;
    boolean running = true;
    Paint white = new Paint();
    Paint green = new Paint();
    public Draw(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        white.setColor(Color.WHITE);
        white.setStyle(Paint.Style.FILL);
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);
    }

    @Override
    public void run() {
        drawSet();
    }

    void drawSet() {
//        int general = gameActivity.firstEdit;
//        int first = general / 10;
//        int second = general % 10;
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    canvas.drawColor(Color.BLUE);
                    int N = 11;
                    int M = 11;
                    int left = 170;
                    int right = 240;
                    int top = 210;
                    int bottom = 140;
                    int battle[][] = new int[N][M];
                    for (int i = 1; i < N; i++) {
                        for (int j = 1; j < M; j++) {
                            canvas.drawRect(left,top,right,bottom,white);
                            left = left + 77;
                            right = right + 77;
                        }
                        top = top + 79;
                        bottom = bottom + 79;
                        left = 170;
                        right = 240;
                    }
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
    public void requestStop() {
        running = false;
    }
}
