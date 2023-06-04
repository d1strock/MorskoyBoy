package com.example.morskoy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Draw extends View {
    Game game;
    int margin = 9;
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
        for (int i = 1; i < game.n - 1; i++) {
            for (int j = 1; j < game.m - 1; j++) {
                if (game.battle[i][j] == 1) {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y - game.kl, green);
                }
                else {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y - game.kl, white);
                }
                game.y = game.y + game.kl + margin;
            }
            game.y = 200;
            game.x = game.x + game.kl + margin;
        }
        game.x = 140;
    }
}
