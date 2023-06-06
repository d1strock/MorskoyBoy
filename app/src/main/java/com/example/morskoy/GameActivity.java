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
    int countOne, countTwo, countThree;


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
        countOne = 0;
        countTwo = 0;
        countThree = 0;
        game.letters.add("А");
        game.letters.add("Б");
        game.letters.add("В");
        game.letters.add("Г");
        game.letters.add("Д");
        game.letters.add("Е");
        game.letters.add("Ж");
        game.letters.add("З");
        game.letters.add("И");
        game.letters.add("К");
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
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ships);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChoose.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                edFirst.setVisibility(View.INVISIBLE);
                edSecond.setVisibility(View.INVISIBLE);
                String item = adapter.getItem(position);
                switch (item) {
                    case "Однопалубный":
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.INVISIBLE);
                        edFirst.setText("");
                        btnSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ButtonLengthOne();
                                game.fixingCoordinatesOne();
                                if (game.flag == 1) {
                                    countOne++;
                                    draw.invalidate();
                                    if (countOne == 4) {
                                        adapter.remove("Однопалубный");
                                        spinnerChoose.setSelection(0);
                                    }
                                }
                                else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case "Двухпалубный":
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.VISIBLE);
                        edFirst.setText("");
                        edSecond.setText("");
                        btnSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ButtonLengthTwo();
                                game.fixingCoordinatesTwo();
                                if (game.flag == 1) {
                                    countTwo++;
                                    draw.invalidate();
                                    if (countTwo == 3) {
                                        adapter.remove("Двухпалубный");
                                        spinnerChoose.setSelection(0);
                                    }
                                }
                                else  Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case "Трехпалубный":
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.VISIBLE);
                        edFirst.setText("");
                        edSecond.setText("");
                        btnSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ButtonLengthTwo();
                                game.fixingCoordinatesThree();
                                if (game.flag == 1) {
                                    countThree++;
                                    draw.invalidate();
                                    if (countThree == 2) {
                                        adapter.remove("Трехпалубный");
                                        spinnerChoose.setSelection(0);
                                    }
                                }
                                else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case "Четырехпалубный":
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.VISIBLE);
                        edFirst.setText("");
                        edSecond.setText("");
                        btnSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ButtonLengthTwo();
                                game.fixingCoordinatesFour();
                                if (game.flag == 1) {
                                    draw.invalidate();
                                    adapter.remove("Четырехпалубный");
                                    spinnerChoose.setSelection(0);
                                }
                                else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
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
        btnSaveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (adapter.getCount() == 1) {
//                    drawViewBot.removeAllViews();
//                    need();
//                    game.tryOne();
//                    game.tryTwo();
//                    game.tryThree();
//                    game.tryFour();
//                }
//                else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                drawViewBot.removeAllViews();
                need();
                game.tryOne();
                game.tryTwo();
            }
        });
    }
    void ButtonLengthOne() {
        String only = edFirst.getText().toString();
        if (only.equals("")) {
            Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        } else {
            String let = String.valueOf(only.charAt(0));
            game.definitionLetter(let);
            game.firstEdLetter = game.helpLetter1 + 3;
            if (game.firstEdLetter == -1) {
                Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
            if (only.length() == 2) {
                try {
                    game.firstEdNumber = Integer.parseInt(String.valueOf(only.charAt(1))) + 3;
                }catch (NumberFormatException e) {
                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            } else if (only.length() == 3) {
                if (String.valueOf(only.charAt(1)).equals("1") && String.valueOf(only.charAt(2)).equals("0")) {
                    game.firstEdNumber = 10 + 3;
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
            game.firstEdLetter = game.helpLetter1 + 3;
            String letter1 = String.valueOf(help1.charAt(0));
            game.definitionLetter(letter1);
            game.secondEdLetter = game.helpLetter1 + 3;
            if (game.firstEdLetter == -1 && game.secondEdLetter == -1) {
                Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
            if (help.length() == 2 && help1.length() == 2) {
                try {
                    game.firstEdNumber = Integer.parseInt(String.valueOf(help.charAt(1))) + 3;
                    game.secondEdNumber = Integer.parseInt(String.valueOf(help1.charAt(1))) + 3;
                } catch (NumberFormatException e) {
                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            } else if (help.length() == 2 && help1.length() == 3) {
                try {
                    game.firstEdNumber = Integer.parseInt(String.valueOf(help.charAt(1))) + 3;
                    if (String.valueOf(help1.charAt(1)).equals("1") && String.valueOf(help1.charAt(2)).equals("0")) {
                        game.secondEdNumber = 10 + 3;
                    } else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            } else if (help.length() == 3 && help1.length() == 3) {
                try {
                    if (String.valueOf(help1.charAt(1)).equals("1") && String.valueOf(help1.charAt(2)).equals("0") && String.valueOf(help.charAt(1)).equals("1") && String.valueOf(help.charAt(2)).equals("0")) {
                        game.secondEdNumber = 10 + 3;
                        game.firstEdNumber = 10 + 3;
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