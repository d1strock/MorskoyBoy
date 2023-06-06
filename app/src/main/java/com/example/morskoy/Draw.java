package com.example.morskoy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Draw extends View {
    Game game;
    int margin = 10;
    Paint white = new Paint();
    Paint green = new Paint();
    public Draw(Context context, Game g) {
        super(context);
        white.setColor(Color.WHITE);
        white.setStyle(Paint.Style.FILL);
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);
        green.setTextSize(60);
        game = g;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        for (int l = 0; l < game.letters.size(); l++) {
            canvas.drawText(game.letters.get(l), game.x + (l * (game.kl + margin)) + game.kl / 5, game.y - margin, green);
        }
        for (int n = 0; n < 10; n++) {
            canvas.drawText(Integer.toString(n+1), game.x - (game.kl), game.y + (n * (game.kl + margin)) + game.kl-margin, green);
        }
        for (int i = 4; i < game.n - 4; i++) {
            for (int j = 4; j < game.m - 4; j++) {
                if (game.battle[i][j] == 1) {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y + game.kl, green);
                }
                else {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y + game.kl, white);
                }
                game.y = game.y + game.kl + margin;
            }
            game.y = 125;
            game.x = game.x + game.kl + margin;
        }
        game.x = 140;
    }
}
