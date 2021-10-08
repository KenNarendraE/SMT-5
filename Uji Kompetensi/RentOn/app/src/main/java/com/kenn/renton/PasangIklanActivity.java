package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PasangIklanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasang_iklan);
        getSupportActionBar().setTitle("Pasang Iklan");
    }
}