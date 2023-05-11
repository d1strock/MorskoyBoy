package com.example.morskoy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Draw extends View {
    GameActivity gameActivity;
    Game game;
    Paint white = new Paint();
    Paint green = new Paint();

    public Draw(Context context, Game g) {
        super(context);
        white.setColor(Color.WHITE);
        white.setStyle(Paint.Style.FILL);
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        int N = 11;
        int M = 11;
        int left = 170;
        int right = 240;
        int top = 200;
        int bottom = 130;
        int battle[][] = new int[N][M];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                canvas.drawRect(left, top, right, bottom, white);
                left = left + 77;
                right = right + 77;
                battle[i][j] = 0;
            }
            top = top + 79;
            bottom = bottom + 79;
            left = 170;
            right = 240;
        }
    }
}
