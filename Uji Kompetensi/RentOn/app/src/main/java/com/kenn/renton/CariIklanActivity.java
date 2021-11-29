package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.kenn.renton.adapter.CariIklanAdapter;
import com.kenn.renton.model.CariIklanModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CariIklanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RecyclerView recyclerView;
    private CariIklanAdapter cariIklanAdapter;
    private ArrayList<CariIklanModel> cariIklanModelArrayList;

    TextView tvHarga,tvWaktu,tvNama,tvLokasi;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_iklan);

        recyclerView = findViewById(R.id.RecycleView);
        tvHarga = findViewById(R.id.tvHarga);
        tvWaktu = findViewById(R.id.tvWaktu);
        tvNama = findViewById(R.id.tvNama);
        tvLokasi = findViewById(R.id.tvLokasi);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);

        refresh();
        //recycleview

//        getData();

//        recyclerView = findViewById(R.id.RecycleView);
//        cariIklanAdapter = new CariIklanAdapter(cariIklanModelArrayList,this);
//
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(CariIklanActivity.this,2);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(cariIklanAdapter);

        //buka bottom sheet
        ImageView btnFilter = findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        //spinner
//        Spinner spinner = findViewById(R.id.spKategori);
//        spinner.setOnItemSelectedListener(this);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//                this,R.array.Kategori, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
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
                cariIklanAdapter = new CariIklanAdapter(response.body(),CariIklanActivity.this);
                cariIklanAdapter.notifyDataSetChanged();

                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(CariIklanActivity.this,2);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(cariIklanAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<CariIklanModel>> call, Throwable t) {

            }
        });
    };

    //show bottom sheet
    private void showDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet);
        bottomSheetDialog.show();


//        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.bottom_sheet);
//
//        dialog.show();
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimaiton;
//        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

//    private void getData() {
//        cariIklanModelArrayList = new ArrayList<>();
//        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}