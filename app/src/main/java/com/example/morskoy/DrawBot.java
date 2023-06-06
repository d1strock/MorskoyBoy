package com.example.morskoy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class DrawBot extends View {
    Game game;
    int margin = 10;
    int towardX;
    int towardY;
    Paint white = new Paint();
    Paint green = new Paint();

    public DrawBot(Context context, Game j) {
        super(context);
        white.setColor(Color.WHITE);
        white.setStyle(Paint.Style.FILL);
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);
        game = j;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        for (int i = 4; i < game.n - 4; i++) {
            for (int j = 4; j < game.m - 4; j++) {
                if (game.battle1[i][j] == 1) {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y + game.kl, green);
                } else {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y + game.kl, white);
                }
                game.y = game.y + game.kl + margin;
            }
            game.y = 125;
            game.x = game.x + game.kl + margin;
        }
        game.x = 140;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        towardX = (int) event.getX();
        towardY = (int) event.getY();
        for (int i = 1; i < game.n - 7; i++) {
            for (int j = 1; j < game.m - 7; j++) {
                if (towardX > game.x + ((i - 1) * (game.kl + margin)) && towardX < game.x + ((margin * (i-1)) + (i * game.kl)) && towardY > game.y + ((j - 1) * (game.kl + margin)) && towardY < game.y + ((margin * (j-1)) + (j * game.kl))) {
                    game.battle1[i+3][j+3] = 1;
                }
            }
        }
        invalidate();
        return true;
    }
}
