package com.example.multiplethemes;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {
    private static final String PREF_THEME = "theme";
    private static final int THEME_ONE = R.style.CustomTheme1;
    private static final int THEME_TWO = R.style.CustomTheme2;
    private static final int THEME_THREE = R.style.CustomTheme3;
    private SharedPreferences sharedPreferences;
    private AppCompatButton buttonTheme1;
    private AppCompatButton buttonTheme2;
    private AppCompatButton buttonTheme3;


    private void initialise() {
        sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
    }

    private void initialiseView() {
        buttonTheme1 = findViewById(R.id.button_theme1);
        buttonTheme2 = findViewById(R.id.button_theme2);
        buttonTheme3 = findViewById(R.id.button_theme3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialise();
        setTheme(sharedPreferences.getInt(PREF_THEME, THEME_ONE));
        setContentView(R.layout.activity_main);

        initialiseView();

        buttonTheme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefTheme(THEME_ONE);
            }
        });
        buttonTheme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefTheme(THEME_TWO);
            }
        });
        buttonTheme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefTheme(THEME_THREE);
            }
        });
    }

    private void setPrefTheme(int theme) {
        sharedPreferences.edit().putInt(PREF_THEME, theme).apply();
        setTheme(sharedPreferences.getInt(PREF_THEME, THEME_ONE));

        // Restart the activity to apply the new theme
        MainActivity.this.recreate();
    }

}