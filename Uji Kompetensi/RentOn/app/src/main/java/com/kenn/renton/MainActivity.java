package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    CardView btnPremium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //coba intent tanpa onclick
        btnPremium = findViewById(R.id.btnPremium);
        btnPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent premium = new Intent(MainActivity.this, PremiumActivity.class);
                startActivity(premium);
            }
        });
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

    public void btnCari(View view) {
        Intent intent = new Intent(this, CariIklanActivity.class);
        startActivity(intent);
    }
}