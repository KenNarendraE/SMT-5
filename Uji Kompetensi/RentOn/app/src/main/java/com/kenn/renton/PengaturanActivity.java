package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kenn.renton.model.UserModel;

public class PengaturanActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);
        getSupportActionBar().setTitle("Pengaturan");

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = sharedPreferences.getString("user", "");
        userModel = gson.fromJson(json, UserModel.class);

        Toast.makeText(this, userModel.getEmail(), Toast.LENGTH_SHORT).show();
    }

    public void btnSimpan(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}