package com.kenn.renton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.kenn.renton.model.CariIklanModel;

import java.io.File;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasangIklanActivity extends AppCompatActivity {

    File file = null;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasang_iklan);
        getSupportActionBar().setTitle("Pasang Iklan");

        img = findViewById(R.id.Igambar);
    }

    public void btnPosting(View view) {
        EditText nama,harga,lokasi,waktu,kategori,deskripsi,waktumax,gambar,telp;

        harga = findViewById(R.id.etjudul);
        nama = findViewById(R.id.etharga);
        lokasi = findViewById(R.id.etalamat);
        waktu = findViewById(R.id.etwaktumin);
        kategori = findViewById(R.id.etwaktumax);
        deskripsi = findViewById(R.id.etdeskripsi);
        waktumax = findViewById(R.id.etkategori);
        gambar = findViewById(R.id.etgambar);
        telp = findViewById(R.id.etTelp);

        if (!nama.getText().toString().isEmpty() && !harga.getText().toString().isEmpty() && !lokasi.getText().toString().isEmpty()&& !waktu.getText().toString().isEmpty()&& !waktumax.getText().toString().isEmpty()&& !deskripsi.getText().toString().isEmpty()&& !kategori.getText().toString().isEmpty()&& !gambar.getText().toString().isEmpty() && !telp.getText().toString().isEmpty()){
            CariIklanModel cariIklanModel = new CariIklanModel(nama.getText().toString(),harga.getText().toString(), lokasi.getText().toString(), waktu.getText().toString(),waktumax.getText().toString(),deskripsi.getText().toString(), kategori.getText().toString(),gambar.getText().toString() ,telp.getText().toString());
            cariIklanModel.setIdpengguna("2");
            Service service = Api.service();
            Call<CariIklanModel> call = service.setData(cariIklanModel);

            Intent i = getIntent();
            int stat = i.getIntExtra("stat",0);

            if (stat==1){
                call.enqueue(new Callback<CariIklanModel>() {
                    @Override
                    public void onResponse(Call<CariIklanModel> call, Response<CariIklanModel> response) {
                        Toast.makeText(PasangIklanActivity.this, "Iklan telah diposting", Toast.LENGTH_SHORT).show();
                        nama.getText().clear();
                        harga.getText().clear();
                        lokasi.getText().clear();
                        waktu.getText().clear();
                        waktumax.getText().clear();
                        deskripsi.getText().clear();
                        kategori.getText().clear();
                        gambar.getText().clear();
                        telp.getText().clear();
                        finish();
                        Intent intent = new Intent(PasangIklanActivity.this,MainActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<CariIklanModel> call, Throwable t) {
                        Toast.makeText(PasangIklanActivity.this, "iklan gagal diposting", Toast.LENGTH_SHORT).show();
                    }
                });
            }else {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }

        }else {
            Toast.makeText(this, "isi data dengan lengkap", Toast.LENGTH_SHORT).show();
        }



//        if (!nama.getText().toString().isEmpty() && !harga.getText().toString().isEmpty() && !lokasi.getText().toString().isEmpty() && !waktu.getText().toString().isEmpty()){
//            CariIklanModel cariIklanModel = new CariIklanModel(nama.getText().toString(),harga.getText().toString(),lokasi.getText().toString(), waktu.getText().toString());
//            // Masukkan sesuai id pengguna
//            cariIklanModel.setIdpengguna("2");
//            Service service = Api.service();
//            Call<CariIklanModel> call = service.setData(cariIklanModel);
//            call.enqueue(new Callback<CariIklanModel>() {
//                @Override
//                public void onResponse(Call<CariIklanModel> call, Response<CariIklanModel> response) {
////                    Toast.makeText(PasangIklanActivity.this,response.message(),Toast.LENGTH_SHORT).show();
//                    Toast.makeText(PasangIklanActivity.this, "Iklan Telah Di posting", Toast.LENGTH_SHORT).show();
//                    nama.getText().clear();
//                    harga.getText().clear();
//                    lokasi.getText().clear();
//                    waktu.getText().clear();
//                    finish();
//                }
//
//                @Override
//                public void onFailure(Call<CariIklanModel> call, Throwable t) {
//                    Toast.makeText(PasangIklanActivity.this, "Iklan Gagal Diposting", Toast.LENGTH_SHORT).show();
//
//                }
//            });
//        }else {
//            Toast.makeText(this, "Isi data dengan lengkap", Toast.LENGTH_SHORT).show();
//        }
    }
    public void iGambar(View view) {
        Toast.makeText(this, "ditekan", Toast.LENGTH_SHORT).show();

        ImagePicker.with(this)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            Uri uri = data.getData();

            file = new File(uri.getPath());

                    // Use Uri object instead of File to avoid storage permissions
                    img.setImageURI(uri);
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
    }
}