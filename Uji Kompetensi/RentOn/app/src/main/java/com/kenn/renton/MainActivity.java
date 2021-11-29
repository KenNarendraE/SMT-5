package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kenn.renton.adapter.CariIklanAdapter;
import com.kenn.renton.model.CariIklanModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CariIklanAdapter cariIklanAdapter;
    private ArrayList<CariIklanModel> cariIklanModelArrayList;

    CardView btnPremium;
    TextView tvHarga,tvWaktu,tvNama,tvLokasi;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refresh();

        //coba intent tanpa onclick
        btnPremium = findViewById(R.id.btnCari);
        btnPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cari = new Intent(MainActivity.this, DetailSearch.class);
                startActivity(cari);
            }
        });


        //RecycleView
        //getData();

//        recyclerView = findViewById(R.id.RecycleViewHome);
//        cariIklanAdapter = new CariIklanAdapter(cariIklanModelArrayList,this);
//
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2) {
//            @Override
//            public boolean canScrollVertically() {
//                return false;
//            }
//        };
//
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(cariIklanAdapter);

        recyclerView = findViewById(R.id.RecycleView);
        tvHarga = findViewById(R.id.tvHarga);
        tvWaktu = findViewById(R.id.tvWaktu);
        tvNama = findViewById(R.id.tvNama);
        tvLokasi = findViewById(R.id.tvLokasi);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    public void refresh(){
        Call<ArrayList<CariIklanModel>> call = Api.service().getData();
        call.enqueue(new Callback<ArrayList<CariIklanModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CariIklanModel>> call, Response<ArrayList<CariIklanModel>> response) {
                cariIklanAdapter = new CariIklanAdapter(response.body(),MainActivity.this);
                cariIklanAdapter.notifyDataSetChanged();

                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,2);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(cariIklanAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<CariIklanModel>> call, Throwable t) {

            }
        });
    };

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

    public void btnIklan(View view) {
        Intent intent = new Intent(this, IklanSayaActivity.class);
        startActivity(intent);
    }

//    private void getData() {
//        cariIklanModelArrayList = new ArrayList<>();
//        cariIklanModelArrayList.add(new CariIklanModel("599000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
//        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
//        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
//        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
//        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
//        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
//        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
//        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
//        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
//        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
//
//    }

    public void btnPremium(View view) {
        Intent intent = new Intent(this, PremiumActivity.class);
        startActivity(intent);
    }

    public void btnNotif(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}