package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_search);
    }

    public void btnSearch(View view) {
        Intent intent = new Intent(this, CariIklanActivity.class);
        startActivity(intent);
    }
}