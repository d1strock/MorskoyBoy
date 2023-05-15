package com.example.morskoy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Draw extends View {
    Game game;
    Paint white = new Paint();
    Paint green = new Paint();
    int N, M, Left, Right, Top, Bottom, firstOne, firstSecond;
    public Draw(Context context, Game g) {
        super(context);
        white.setColor(Color.WHITE);
        white.setStyle(Paint.Style.FILL);
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);
        N = g.n;
        M = g.m;
        Left = g.left;
        Right = g.right;
        Bottom = g.bottom;
        Top = g.top;
        firstOne = g.first1 / 10;
        firstSecond = g.first1 % 10;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (firstOne == i && firstSecond == j) {
                    canvas.drawRect(Left, Top, Right, Bottom, green);
                }
                else {
                    canvas.drawRect(Left, Top, Right, Bottom, white);
                }
                Left = Left + 77;
                Right = Right + 77;
            }
            Top = Top + 79;
            Bottom = Bottom + 79;
            Left = 170;
            Right = 240;
        }
        Top = 200;
        Bottom = 130;
    }
}
