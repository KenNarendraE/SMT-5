package com.kenn.renton;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.kenn.renton.model.CariIklanModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailIklanActivity extends AppCompatActivity {

    TextView harga,nama,lokasi,waktu,deskripsi,waktumax,gambar;
    //String gambar;
    ImageView imGDetail;
    Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_iklan);
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

        btnPesan = findViewById(R.id.btnPesan);
        String num = "+62895326442200";
        String text = "Halo gan, Apa barang ini masih disewakan?";

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean installed = isAppInstalled("com.whatsapp");

                if (installed){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://api.whatsapp.com/send?phone="+num+"&text="+text));
                    startActivity(intent);
                }else {
                    Toast.makeText(DetailIklanActivity.this,"whatsapp is not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;

        try {
            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
            is_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            is_installed = true;
            e.printStackTrace();
        }
        return is_installed;
    }

//    public void btnHapus(View view) {
//        String id = getIntent().getStringExtra("idiklan");
//        Service service = Api.service();
//        Call<CariIklanModel> call = service.deleteData(id);
//        call.enqueue(new Callback<CariIklanModel>() {
//            @Override
//            public void onResponse(Call<CariIklanModel> call, Response<CariIklanModel> response) {
//                Toast.makeText(DetailIklanActivity.this, "Data Sudah dihapus", Toast.LENGTH_SHORT).show();
//                finish();
//            }
//
//            @Override
//            public void onFailure(Call<CariIklanModel> call, Throwable t) {
//                Toast.makeText(DetailIklanActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public void btnTelpon(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0895326442200"));
        startActivity(intent);
    }
}
