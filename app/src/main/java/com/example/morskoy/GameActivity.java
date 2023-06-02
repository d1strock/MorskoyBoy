package com.example.morskoy;

import androidx.appcompat.app.AppCompatActivity;

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

public class GameActivity extends AppCompatActivity {
    LinearLayout drawView;
    Draw draw;
    Game game;
    TextView tvHelp;
    Spinner spinnerChoose;
    LinearLayout editTexts;
    Button btnSave;
    EditText edFirst, edSecond;
    String ships[] = new String[]{"Корабль", "Однопалубный", "Двухпалубный", "Трехпалубный", "Четырехпалубный"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_game);
        drawView = findViewById(R.id.drawView);
        game = new Game();
        draw = new Draw(this, game);
        drawView.addView(draw);
        tvHelp = findViewById(R.id.tvHelp);
        spinnerChoose = findViewById(R.id.spinnerChoose);
        editTexts = findViewById(R.id.editTexts);
        btnSave = findViewById(R.id.btnSave);
        edFirst = findViewById(R.id.edFirst);
        edSecond = findViewById(R.id.edSecond);
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
                        break;
                    case 2:

                    case 3:
                        btnSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ButtonLengthTwo();
                                if (game.firstEdLetter == -1 && game.secondEdLetter == -1) {
                                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                                } else {
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
//                                else if (help1.length() == 3 && help.length() == 2) {
//                                    String letter = String.valueOf(help.charAt(0));
//                                    game.definitionLetter(letter);
//                                    game.firstEdLetter = game.helpLetter1;
//                                    String letter1 = String.valueOf(help1.charAt(0));
//                                    game.definitionLetter(letter1);
//                                    game.secondEdLetter = game.helpLetter1;
//                                    if (String.valueOf(help1.charAt(2)).equals("0") && String.valueOf(help.charAt(1)).equals("1")) {
//                                        game.firstEdNumber = Integer.parseInt(String.valueOf(help.charAt(1)));
//                                        game.secondEdNumber = 10;
//                                        if (game.firstEdLetter == -1 && game.secondEdLetter == -1) {
//                                            Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
//                                        }
//                                        else {
//                                            if (game.secondEdLetter - game.firstEdLetter == 2) {
//                                                game.battle[game.firstEdLetter][game.firstEdNumber] = 1;
//                                                game.battle[game.secondEdLetter][game.secondEdNumber] = 1;
//                                                game.battle[game.firstEdLetter + 1][game.firstEdNumber] = 1;
//                                                draw.invalidate();
//                                            } else if (game.secondEdNumber - game.firstEdNumber == 2) {
//                                                game.battle[game.firstEdLetter][game.firstEdNumber] = 1;
//                                                game.battle[game.secondEdLetter][game.secondEdNumber] = 1;
//                                                game.battle[game.firstEdLetter][game.firstEdNumber + 1] = 1;
//                                                draw.invalidate();
//                                            } else
//                                                Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                    else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
//                                }
                            }
                        });
                    case 4:
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerChoose.setOnItemSelectedListener(itemSelectedListener);
    }

    void ButtonLengthTwo() {
        String help = edFirst.getText().toString();
        String help1 = edSecond.getText().toString();
        if (help.equals("") && help1.equals("")) {
            Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        }
        else {
            String letter = String.valueOf(help.charAt(0));
            game.definitionLetter(letter);
            game.firstEdLetter = game.helpLetter1;
            String letter1 = String.valueOf(help1.charAt(0));
            game.definitionLetter(letter1);
            game.secondEdLetter = game.helpLetter1;
        }
        if (help.length() == 2 && help1.length() == 2) {
            try {
                game.firstEdNumber = Integer.parseInt(String.valueOf(help.charAt(1)));
                game.secondEdNumber = Integer.parseInt(String.valueOf(help1.charAt(1)));
            } catch (NumberFormatException e) {
                Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
        else if (help.length() == 2 && help1.length() == 3) {
            try {
                 game.firstEdNumber = Integer.parseInt(String.valueOf(help.charAt(1)));
                if (String.valueOf(help1.charAt(1)).equals("1") && String.valueOf(help1.charAt(2)).equals("0")) {
                    game.secondEdNumber = 10;
                }
                else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
        else Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
    }
    void ButtonLengthThree() {

    }
}