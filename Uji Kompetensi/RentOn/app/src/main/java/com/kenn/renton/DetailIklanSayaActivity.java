package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kenn.renton.model.CariIklanModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailIklanSayaActivity extends AppCompatActivity {

    TextView harga,nama,lokasi,waktu,deskripsi,waktumax,gambar;
    ImageView imGDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_iklan_saya);

        harga = findViewById(R.id.tvDHarga);
        nama = findViewById(R.id.tvDNama);
        lokasi = findViewById(R.id.tvDLokasi);
        waktu = findViewById(R.id.tvDWaktu);
        waktumax = findViewById(R.id.tvDWaktuM);
        deskripsi = findViewById(R.id.tvDDeskripsi);
        gambar = findViewById(R.id.tvDGambar);
        imGDetail = findViewById(R.id.imGDetail);

        Intent intent = getIntent();
        harga.setText(intent.getStringExtra("harga"));
        nama.setText(intent.getStringExtra("nama"));
        lokasi.setText(intent.getStringExtra("lokasi"));
        waktu.setText(intent.getStringExtra("waktu"));
        waktumax.setText(intent.getStringExtra("waktumax"));
        deskripsi.setText(intent.getStringExtra("deskripsi"));

        gambar.setText(intent.getStringExtra("gambar"));
        String stringimg = gambar.getText().toString();
        Glide.with(getApplicationContext()).load("http://192.168.100.4:8081/upload/"+stringimg).into(imGDetail);

    }

    public void btnHapus(View view) {
        String id = getIntent().getStringExtra("idiklan");
        Service service = Api.service();
        Call<CariIklanModel> call = service.deleteData(id);
        call.enqueue(new Callback<CariIklanModel>() {
            @Override
            public void onResponse(Call<CariIklanModel> call, Response<CariIklanModel> response) {
                Toast.makeText(DetailIklanSayaActivity.this, "Data Sudah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<CariIklanModel> call, Throwable t) {
                Toast.makeText(DetailIklanSayaActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}