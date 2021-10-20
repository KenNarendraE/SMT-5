package com.kenn.renton;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailIklanActivity extends AppCompatActivity {

    TextView harga,nama,lokasi,waktu;
    Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_iklan);
        harga = findViewById(R.id.tvDHarga);
        nama = findViewById(R.id.tvDNama);
        lokasi = findViewById(R.id.tvDLokasi);
        waktu = findViewById(R.id.tvDWaktu);

        Intent intent = getIntent();
        harga.setText(intent.getStringExtra("harga"));
        nama.setText(intent.getStringExtra("nama"));
        lokasi.setText(intent.getStringExtra("lokasi"));
        waktu.setText(intent.getStringExtra("waktu"));

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

}
