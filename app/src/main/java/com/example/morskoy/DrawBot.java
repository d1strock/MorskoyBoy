package com.example.morskoy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class DrawBot extends View {
    Method method;
    Game game;
    int margin = 10;
    int towardX;
    int towardY;
    Paint white = new Paint();
    Paint red = new Paint();
    Paint grey = new Paint();
    Paint green = new Paint();

    public DrawBot(Context context, Game j) {
        super(context);
        white.setColor(Color.WHITE);
        white.setStyle(Paint.Style.FILL);
        red.setColor(Color.RED);
        red.setStyle(Paint.Style.FILL);
        grey.setColor(Color.GRAY);
        grey.setStyle(Paint.Style.FILL);
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);
        green.setTextSize(60);
        game = j;
        method = (Method) context;
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
                if (game.battle1[i][j] == 1) {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y + game.kl, red);
                } else if (game.battle1[i][j] == 2) {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y + game.kl, grey);
                } else {
                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y + game.kl, white);
                }
//                if (game.battle1[i][j] == 3) {
//                    canvas.drawRect(game.x, game.y, game.x + game.kl, game.y + game.kl, green);
//                }
//                else canvas.drawRect(game.x, game.y, game.x + game.kl, game.y + game.kl, white);
                game.y = game.y + game.kl + margin;
            }
            game.y = 125;
            game.x = game.x + game.kl + margin;
        }
        game.x = 140;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (game.time == true) {
            towardX = (int) event.getX();
            towardY = (int) event.getY();
            for (int i = 1; i < game.n - 7; i++) {
                for (int j = 1; j < game.m - 7; j++) {
                    if (towardX > game.x + ((i - 1) * (game.kl + margin)) && towardX < game.x + ((margin * (i-1)) + (i * game.kl)) && towardY > game.y + ((j - 1) * (game.kl + margin)) && towardY < game.y + ((margin * (j-1)) + (j * game.kl))) {
                        if (game.battle1[i+3][j+3] == 3) {
                            game.battle1[i+3][j+3] = 1;
                            if (game.battle1[i+3][j+4] != 3 && game.battle1[i+3][j+2] != 3 && game.battle1[i+4][j+3] != 3 && game.battle1[i+2][j+3] != 3) {
                                game.battle1[i+3][j+4] = 2;
                                game.battle1[i+3][j+2] = 2;
                                game.battle1[i+4][j+3] = 2;
                                game.battle1[i+2][j+3] = 2;
                                game.battle1[i+2][j+2] = 2;
                                game.battle1[i+4][j+2] = 2;
                                game.battle1[i+2][j+4] = 2;
                                game.battle1[i+4][j+4] = 2;
                            }
                        }
                        else if (game.battle1[i+3][j+3] == 0) {
                            game.battle1[i+3][j+3] = 2;
                        }
                        else if (game.battle1[i+3][j+3] == 2) {
                            game.battle1[i+3][j+3] = 2;
                        }
                    }
                }
            }
        }
        invalidate();
        for (int i = 4; i < game.n - 4; i++) {
            for (int j = 4; j < game.m - 4; j++) {
                if (game.battle1[i][j] == 3) {
                    game.countVictoryPlayer ++;
                }
            }
        }
        game.time = false;
        method.play();
        return true;
    }
}
