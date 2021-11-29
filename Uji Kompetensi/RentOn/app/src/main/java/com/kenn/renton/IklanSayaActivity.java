package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.kenn.renton.adapter.CariIklanAdapter;
import com.kenn.renton.adapter.IklanSayaAdapter;
import com.kenn.renton.model.CariIklanModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IklanSayaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private IklanSayaAdapter iklanSayaAdapter;
    private ArrayList<CariIklanModel> cariIklanModelArrayList;

    TextView tvHarga,tvWaktu,tvNama,tvLokasi;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iklan_saya);

        recyclerView = findViewById(R.id.RecycleView);
        tvHarga = findViewById(R.id.tvHarga);
        tvWaktu = findViewById(R.id.tvWaktu);
        tvNama = findViewById(R.id.tvNama);
        tvLokasi = findViewById(R.id.tvLokasi);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);

        refresh();

    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    public void refresh(){
        Call<ArrayList<CariIklanModel>> call = Api.service().getDataKu();
        call.enqueue(new Callback<ArrayList<CariIklanModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CariIklanModel>> call, Response<ArrayList<CariIklanModel>> response) {
                iklanSayaAdapter = new IklanSayaAdapter(response.body(),IklanSayaActivity.this);
                iklanSayaAdapter.notifyDataSetChanged();

                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(IklanSayaActivity.this,2);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(iklanSayaAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<CariIklanModel>> call, Throwable t) {

            }
        });
    }
}