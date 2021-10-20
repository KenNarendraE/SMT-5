package com.kenn.renton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kenn.renton.adapter.CariIklanAdapter;
import com.kenn.renton.model.CariIklanModel;

import java.util.ArrayList;

public class CariIklanActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CariIklanAdapter cariIklanAdapter;
    private ArrayList<CariIklanModel> cariIklanModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_iklan);

        getData();

        recyclerView = findViewById(R.id.RecycleView);
        cariIklanAdapter = new CariIklanAdapter(cariIklanModelArrayList,this);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(CariIklanActivity.this,2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cariIklanAdapter);


    }

    private void getData() {
        cariIklanModelArrayList = new ArrayList<>();
        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));
        cariIklanModelArrayList.add(new CariIklanModel("5000Rp/Jam","AE86","Sidoarjo", "1 - 7 Hari"));

    }
}