package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kenn.renton.model.LoginModel;
import com.kenn.renton.model.LoginForm;
import com.kenn.renton.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    SharedPreferences sharedPreferences;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        //coba intent tanpa onclick
//        btnLogin = findViewById(R.id.btnLogin);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                open();
//            }
//        });
    }


//    public void btnLogin(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }

    public void btnDaftar(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void btnLogin(View view) {
        EditText etemail, etpassword;

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        etemail = findViewById(R.id.etEmail);
        etpassword = findViewById(R.id.etPassword);

        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();

        //sharedpreferences

        if (!etemail.getText().toString().isEmpty() && !etpassword.getText().toString().isEmpty()){
            LoginForm penggunaModel = new LoginForm(etemail.getText().toString(), etpassword.getText().toString());
            Service service = Api.service();
            Call<LoginModel> call = service.setLogin(penggunaModel);
            Log.d("url",call.request().url().toString());
            call.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
//                    Toast.makeText(LoginActivity.this, response.body().getPesan().toString(), Toast.LENGTH_SHORT).show();
                        if (response.body() == null){
                            Toast.makeText(LoginActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent login = new Intent(LoginActivity.this, MainActivity.class);

                            userModel = response.body().getData();
                            Gson gson = new Gson();
                            String json = gson.toJson(userModel);
                            editor.putString("user", json);
                            editor.commit();

//                            Intent i = new Intent (LoginActivity.this, PasangIklanActivity.class);
//                            i.putExtra("stat", 1);
//                            startActivity(i);

                            startActivity(login);
                        }
                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {

                }
            });
        }else {
            Toast.makeText(LoginActivity.this, "Isi email atau password", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnLupa(View view) {
        Intent intent = new Intent(this, NotifikasiActivity.class);
        startActivity(intent);
    }
}