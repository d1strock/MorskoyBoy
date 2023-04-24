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

public class GameActivity extends AppCompatActivity {
    LinearLayout drawView;
    TextView tvHelp;
    ImageView helper;
    Spinner spinnerChoose;
    LinearLayout editTexts;
    Button btnSave;
    EditText edFirst, edSecond, edThird, edFourth;
    String ships[] = new String[]{"...","Однопалубный","Двухпалубный","Трехпалубный","Четырехпалубный"};
    int firstEdit = 0;
    int secondEdit = 0;
    int thirdEdit = 0;
    int fourthEdit = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_game);
        drawView = findViewById(R.id.drawView);
        drawView.addView(new DrawView(this));
        helper = findViewById(R.id.helper);
        tvHelp = findViewById(R.id.tvHelp);
        spinnerChoose = findViewById(R.id.spinnerChoose);
        editTexts = findViewById(R.id.editTexts);
        btnSave = findViewById(R.id.btnSave);
        edFirst = findViewById(R.id.edFirst);
        edSecond = findViewById(R.id.edSecond);
        edThird = findViewById(R.id.edThird);
        edFourth = findViewById(R.id.edFourth);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ships);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChoose.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                edFirst.setVisibility(View.INVISIBLE);
                edSecond.setVisibility(View.INVISIBLE);
                edThird.setVisibility(View.INVISIBLE);
                edFourth.setVisibility(View.INVISIBLE);
                int item = position;
                switch (item) {
                    case 1:
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.INVISIBLE);
                        edThird.setVisibility(View.INVISIBLE);
                        edFourth.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.VISIBLE);
                        edThird.setVisibility(View.INVISIBLE);
                        edFourth.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.VISIBLE);
                        edThird.setVisibility(View.VISIBLE);
                        edFourth.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        edFirst.setVisibility(View.VISIBLE);
                        edSecond.setVisibility(View.VISIBLE);
                        edThird.setVisibility(View.VISIBLE);
                        edFourth.setVisibility(View.VISIBLE);
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