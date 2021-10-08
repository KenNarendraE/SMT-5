package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAkun(View view) {
        Intent intent = new Intent(this, PengaturanActivity.class);
        startActivity(intent);
    }

    public void btnPengaturan(View view) {
        Intent intent = new Intent(this, Pengaturan2Activity.class);
        startActivity(intent);
    }

    public void btnPasang(View view) {
        Intent intent = new Intent(this, PasangIklanActivity.class);
        startActivity(intent);
    }
}