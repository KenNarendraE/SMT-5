package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etNama,etEmail,etPw,etAl,etTp,etUmur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Daftar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etPw = findViewById(R.id.etPw);
        if (etPw.getText().toString().length()<=8) {
            etPw.setError("Password kurang dari 8");
        }
    }

//    username = (EditText) findViewById(R.id.etxUsername);
//if(username.getText().toString().length()==0){
//        username.setError("Username diperlukan!");



    public void btnLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Registrasi berhasil, kembali ke Login", Toast.LENGTH_SHORT).show();
    }
}