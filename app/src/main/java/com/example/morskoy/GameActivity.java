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
    EditText edFirst, edSecond, edThird, edFourth;
    String ships[] = new String[]{"Корабль","Однопалубный","Двухпалубный","Трехпалубный","Четырехпалубный"};


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
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String help = edFirst.getText().toString();
//                String help1 = edSecond.getText().toString();
//                if (help.equals("") && help1.equals("")) {
//                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    game.firstEd = Integer.parseInt(edFirst.getText().toString());
//                    game.secondEd = Integer.parseInt(edSecond.getText().toString());
//                    if (game.firstEd < 100 && game.firstEd > -1 && game.secondEd < 100 && game.secondEd > -1) {
//                        game.battle[game.firstEd / 10][game.firstEd % 10] = 1;
//                        game.battle[game.secondEd / 10][game.secondEd % 10] = 1;
//                        draw.invalidate();
//                    }
//                    else Toast.makeText(GameActivity.this, "Неверная координата", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
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
                                String help = edFirst.getText().toString();
                                String help1 = edSecond.getText().toString();
                                if (help.equals("") && help1.equals("")) {
                                    Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    game.firstEd = Integer.parseInt(edFirst.getText().toString());
                                    game.secondEd = Integer.parseInt(edSecond.getText().toString());
                                    if (game.secondEd / 10 - game.firstEd / 10 == 2) {
                                        game.battle[game.firstEd / 10][game.firstEd % 10] = 1;
                                        game.battle[game.secondEd / 10][game.secondEd % 10] = 1;
                                        game.battle[(game.firstEd / 10) + 1][game.firstEd % 10] = 1;
                                        draw.invalidate();
                                    }
                                    else if (game.secondEd % 10 - game.firstEd % 10 == 2) {
                                        game.battle[game.firstEd / 10][game.firstEd % 10] = 1;
                                        game.battle[game.secondEd / 10][game.secondEd % 10] = 1;
                                        game.battle[game.firstEd / 10][(game.firstEd % 10) + 1] = 1;
                                        draw.invalidate();
                                    }
                                    else  Toast.makeText(GameActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                                }
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
}