package com.example.morskoy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Draw extends View {
    Game game;
    int margin = 7;
    Paint white = new Paint();
    Paint green = new Paint();
    public Draw(Context context, Game g) {
        super(context);
        white.setColor(Color.WHITE);
        white.setStyle(Paint.Style.FILL);
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);
        game = g;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        for (int i = 0; i < game.n; i++) {
            for (int j = 0; j < game.m; j++) {
                if (game.battle[i][j] == 1) {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y - game.kl, green);
                }
                else {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y - game.kl, white);
                }
                game.x = game.x + game.kl + margin;
            }
            game.x = 170;
            game.y = game.y + game.kl + margin;
        }
        game.y = 200;
//        for (int i = 1; i < N; i++) {
//            for (int j = 1; j < M; j++) {
//                if (firstOne1 == i && firstSecond1 == j) {
//                    canvas.drawRect(Left, Top, Right, Bottom, green);
//                }
//                else {
//                    canvas.drawRect(Left, Top, Right, Bottom, white);
//                }
//                Left = Left + 77;
//                Right = Right + 77;
//            }
//            Top = Top + 79;
//            Bottom = Bottom + 79;
//            Left = 170;
//            Right = 240;
//        }
//        Top = 200;
//        Bottom = 130;
    }
}
