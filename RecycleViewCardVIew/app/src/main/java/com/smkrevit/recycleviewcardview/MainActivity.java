package com.smkrevit.recycleviewcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SiswaAdapter adapter;
    List<Siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        isiData();
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvSiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiData(){

        siswaList = new ArrayList<Siswa>();
        siswaList.add(new Siswa("joni", "surabaya"));
        siswaList.add(new Siswa("bob", "surabaya"));
        siswaList.add(new Siswa("steve", "surabaya"));
        siswaList.add(new Siswa("hanz", "surabaya"));
        siswaList.add(new Siswa("elatiora", "surabaya"));
        siswaList.add(new Siswa("hyona", "surabaya"));
        siswaList.add(new Siswa("joni", "surabaya"));
        siswaList.add(new Siswa("joni", "surabaya"));
        siswaList.add(new Siswa("joni", "surabaya"));
        siswaList.add(new Siswa("joni", "surabaya"));
        siswaList.add(new Siswa("joni", "surabaya"));
        siswaList.add(new Siswa("joni", "surabaya"));
        siswaList.add(new Siswa("joni", "surabaya"));
        siswaList.add(new Siswa("joni", "surabaya"));
        siswaList.add(new Siswa("joni", "surabaya"));

        adapter = new SiswaAdapter(this,siswaList);
        recyclerView.setAdapter(adapter);

    }

    public void btnTambah(View view) {
        siswaList.add(new Siswa("JONNI", "DDARJO"));
        adapter.notifyDataSetChanged();
    }
}