package com.company.retrofit_rest_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textA, textB, textC, textD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textA = findViewById(R.id.textViewA);
        textB = findViewById(R.id.textViewB);
        textC = findViewById(R.id.textViewC);
        textD = findViewById(R.id.textViewD);


    }
}