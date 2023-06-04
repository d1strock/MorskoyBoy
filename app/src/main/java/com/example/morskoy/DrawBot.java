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
    int towardX = 0;
    int towardY = 0;
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
        for (int i = 1; i < game.n - 1; i++) {
            for (int j = 1; j < game.m - 1; j++) {
                if (game.battle1[i][j] == 1) {
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch ( event.getAction() ) {
            case MotionEvent.ACTION_DOWN:
                towardX = (int)event.getX();
                towardY = (int)event.getY();
                for (int i = 1; i < game.n - 1; i++) {
                    for (int j = 1; j < game.m - 1; j++) {
//                        if (towardX > 170 + ((i - 1) * game.kl) && towardX < 170 + (i * game.kl) && towardY > 200 + ((j - 1) * game.kl) && towardY < 200 + (j * game.kl)) {
//                            game.battle1[i][j] = 1;
//                        }
                        if (towardX > 170 + ((i - 1) * (game.kl + margin)) && towardX < 170 + margin + (i * game.kl) && towardY > 200 + ((j - 1) * (game.kl + margin)) && towardY < 200 + margin + (j * game.kl)) {
                            game.battle1[i][j] = 1;
                        }
                        else game.battle1[i][j] = 0;
                    }
                }
                invalidate();
        }
        return true;
    }
}
