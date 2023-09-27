package com.byteforce.proplanetpersonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NAME = "MyAppPrefs";
    private static final String PREF_FIRST_TIME = "isFirstTime";
    private Button log_in;
    private Button btnGoogleAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log_in = findViewById(R.id.log_in);
        btnGoogleAuth = findViewById(R.id.btnGoogleAuth);

        btnGoogleAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This Option Is Under Testing/Production", Toast.LENGTH_SHORT).show();
            }
        });

            // Check if the app is opened for the first time
            SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            boolean isFirstTime = sharedPreferences.getBoolean(PREF_FIRST_TIME, true);

            if (isFirstTime) {
                sharedPreferences.edit().putBoolean(PREF_FIRST_TIME, false).apply();
            } else {
                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
                finish(); // I am Closing the MainActivity so the user can't navigate back to it
            }

            log_in.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Thanks For Being A Pro Planet Person ", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                    finish();
                }
            });

            // Snipper code for chosing language

        String[] options = {"English", "हिन्दी", "தமிழ்"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedOption = options[position];
                // Handle the selected option here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case where nothing is selected
            }
        });




    }
}