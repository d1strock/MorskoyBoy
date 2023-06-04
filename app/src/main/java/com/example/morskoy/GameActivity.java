package com.example.morskoy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class GameActivity extends AppCompatActivity {
    LinearLayout drawView, drawViewBot;
    Draw draw;
    DrawBot drawBot;
    Game game;
    TextView tvHelp;
    Spinner spinnerChoose;
    LinearLayout editTexts;
    Button btnSave, btnSaveAll;
    EditText edFirst, edSecond;
    ArrayList<String> ships = new ArrayList<>();


    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_game);
        drawView = findViewById(R.id.drawView);
        drawViewBot = findViewById(R.id.drawViewBot);
        game = new Game();
        draw = new Draw(this, game);
        drawView.addView(draw);
        tvHelp = findViewById(R.id.tvHelp);
        spinnerChoose = findViewById(R.id.spinnerChoose);
        editTexts = findViewById(R.id.editTexts);
        btnSave = findViewById(R.id.btnSave);
        btnSaveAll = findViewById(R.id.btnSaveAll);
        edFirst = findViewById(R.id.edFirst);
        edSecond = findViewById(R.id.edSecond);
        ships.add("Корабль");
        ships.add("Однопалубный");
        ships.add("Двухпалубный");
        ships.add("Трехпалубный");
        ships.add("Четырехпалубный");
        btnSaveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawViewBot.removeAllViews();
                need();
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ships);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChoose.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                edFirst.setVisibility(View.INVISIBLE);
                edSecond.setVisibility(View.INVISIBLE);
                int item = position;
                switch (item) {
                    case 1:
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.INVISIBLE);
                        edFirst.setText("");
                        btnSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ButtonLengthOne();
                                game.battle[game.firstEdLetter][game.firstEdNumber] = 1;
                                draw.invalidate();
                            }
                        });
                        break;
                    case 2:
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.VISIBLE);
                        edFirst.setText("");
                        edSecond.setText("");
                        btnSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ButtonLengthTwo();
                                if (game.secondEdLetter - game.firstEdLetter == 1 && game.firstEdNumber == game.secondEdNumber) {
                                    game.battle[game.firstEdLetter][game.firstEdNumber] = 1;
                                    game.battle[game.secondEdLetter][game.secondEdNumber] = 1;
                                    draw.invalidate();
                                } else if (game.secondEdNumber - game.firstEdNumber == 1 && game.firstEdLetter == game.secondEdLetter) {
                                    game.battle[game.firstEdLetter][game.firstEdNumber] = 1;
                                    game.battle[game.secondEdLetter][game.secondEdNumber] = 1;
                                    draw.invalidate();
                                } else
                                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case 3:
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.VISIBLE);
                        edFirst.setText("");
                        edSecond.setText("");
                        btnSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ButtonLengthTwo();
                                if (game.secondEdLetter - game.firstEdLetter == 2 && game.firstEdNumber == game.secondEdNumber) {
                                    game.battle[game.firstEdLetter][game.firstEdNumber] = 1;
                                    game.battle[game.secondEdLetter][game.secondEdNumber] = 1;
                                    game.battle[game.firstEdLetter + 1][game.firstEdNumber] = 1;
                                    draw.invalidate();
                                } else if (game.secondEdNumber - game.firstEdNumber == 2 && game.firstEdLetter == game.secondEdLetter) {
                                    game.battle[game.firstEdLetter][game.firstEdNumber] = 1;
                                    game.battle[game.secondEdLetter][game.secondEdNumber] = 1;
                                    game.battle[game.firstEdLetter][game.firstEdNumber + 1] = 1;
                                    draw.invalidate();
                                } else
                                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case 4:
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.VISIBLE);
                        edFirst.setText("");
                        edSecond.setText("");
                        btnSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ButtonLengthTwo();
                                if (game.secondEdLetter - game.firstEdLetter == 3 && game.firstEdNumber == game.secondEdNumber) {
                                    game.battle[game.firstEdLetter][game.firstEdNumber] = 1;
                                    game.battle[game.secondEdLetter][game.secondEdNumber] = 1;
                                    game.battle[game.firstEdLetter + 1][game.firstEdNumber] = 1;
                                    game.battle[game.firstEdLetter + 2][game.firstEdNumber] = 1;
                                    draw.invalidate();
                                } else if (game.secondEdNumber - game.firstEdNumber == 3 && game.firstEdLetter == game.secondEdLetter) {
                                    game.battle[game.firstEdLetter][game.firstEdNumber] = 1;
                                    game.battle[game.secondEdLetter][game.secondEdNumber] = 1;
                                    game.battle[game.firstEdLetter][game.firstEdNumber + 1] = 1;
                                    game.battle[game.firstEdLetter][game.firstEdNumber + 2] = 1;
                                    draw.invalidate();
                                    adapter.remove("Четырехпалубный");
                                } else
                                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerChoose.setOnItemSelectedListener(itemSelectedListener);
    }
    void ButtonLengthOne() {
        String only = edFirst.getText().toString();
        if (only.equals("")) {
            Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        } else {
            String let = String.valueOf(only.charAt(0));
            game.definitionLetter(let);
            game.firstEdLetter = game.helpLetter1;
            if (game.firstEdLetter == -1) {
                Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
            if (only.length() == 2) {
                try {
                    game.firstEdNumber = Integer.parseInt(String.valueOf(only.charAt(1)));
                }catch (NumberFormatException e) {
                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            } else if (only.length() == 3) {
                if (String.valueOf(only.charAt(1)).equals("1") && String.valueOf(only.charAt(2)).equals("0")) {
                    game.firstEdNumber = 10;
                }
            }
            else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }

    void ButtonLengthTwo() {
        String help = edFirst.getText().toString();
        String help1 = edSecond.getText().toString();
        if (help.equals("") || help1.equals("")) {
            Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        } else {
            String letter = String.valueOf(help.charAt(0));
            game.definitionLetter(letter);
            game.firstEdLetter = game.helpLetter1;
            String letter1 = String.valueOf(help1.charAt(0));
            game.definitionLetter(letter1);
            game.secondEdLetter = game.helpLetter1;
            if (game.firstEdLetter == -1 && game.secondEdLetter == -1) {
                Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
            if (help.length() == 2 && help1.length() == 2) {
                try {
                    game.firstEdNumber = Integer.parseInt(String.valueOf(help.charAt(1)));
                    game.secondEdNumber = Integer.parseInt(String.valueOf(help1.charAt(1)));
                } catch (NumberFormatException e) {
                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            } else if (help.length() == 2 && help1.length() == 3) {
                try {
                    game.firstEdNumber = Integer.parseInt(String.valueOf(help.charAt(1)));
                    if (String.valueOf(help1.charAt(1)).equals("1") && String.valueOf(help1.charAt(2)).equals("0")) {
                        game.secondEdNumber = 10;
                    } else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            } else if (help.length() == 3 && help1.length() == 3) {
                try {
                    if (String.valueOf(help1.charAt(1)).equals("1") && String.valueOf(help1.charAt(2)).equals("0") && String.valueOf(help.charAt(1)).equals("1") && String.valueOf(help.charAt(2)).equals("0")) {
                        game.secondEdNumber = 10;
                        game.firstEdNumber = 10;
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            } else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }
    void need() {
        drawBot = new DrawBot(this, game);
        drawViewBot.addView(drawBot);
    }
}