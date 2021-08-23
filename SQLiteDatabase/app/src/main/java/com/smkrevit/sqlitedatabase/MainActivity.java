package com.smkrevit.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database db;
    EditText etBarang, etStok, etHarga;
    TextView tvPilihan;

    List<Barang> databarang = new ArrayList<Barang>();
    BarangAdapter adapter;
    RecyclerView rcvBarang;

    String idbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    load();
    selectData();
    }

    public void load(){
        db = new Database(this);
        db.buatTabel();

        etBarang = findViewById(R.id.etBarang);
        etHarga = findViewById(R.id.etHarga);
        etStok = findViewById(R.id.etStok);
        tvPilihan = findViewById(R.id.tvPilihan);
        rcvBarang = findViewById(R.id.rcvBarang);

        rcvBarang.setLayoutManager(new LinearLayoutManager(this));
        rcvBarang.setHasFixedSize(true);
    }

    public void simpan(View view) {
        String barang = etBarang.getText().toString();
        String harga = etHarga.getText().toString();
        String stok = etStok.getText().toString();
        String pilihan = tvPilihan.getText().toString();

        if(barang.isEmpty() || harga.isEmpty() || stok.isEmpty()){
            pesan("Ada data yang kosong");
        }else{
            if (pilihan.equals("Insert")){
                String sql = "INSERT INTO tblbarang (barang,stok,harga) VALUES ('"+barang+"',"+stok+","+harga+")";
                if (db.runSQL(sql)){
                    pesan("insert berhasil");
                    selectData();
                }else{
                    pesan("insert gagal");
                }
            }else {
                String sql = "UPDATE tblbarang SET barang = '"+barang+"', stok = "+stok+", harga = "+harga+" WHERE idbarang = "+idbarang+" ;";
                if (db.runSQL(sql)){
                    pesan("data berhasil diubah");
                    selectData();
                }else {
                    pesan("data tidak bisa diubah");
                }
            }
        }

        etBarang.setText("");
        etHarga.setText("");
        etStok.setText("");
        tvPilihan.setText("Insert");
    }

    public void pesan (String isi){
        Toast.makeText(this,isi,Toast.LENGTH_LONG).show();
    }

    public void selectData(){
        String sql = "SELECT * FROM tblbarang ORDER BY barang ASC";
        Cursor cursor = db.select(sql);
        databarang.clear();
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                String idbarang = cursor.getString(cursor.getColumnIndex("idbarang"));
                String barang = cursor.getString(cursor.getColumnIndex("barang"));
                String stok = cursor.getString(cursor.getColumnIndex("stok"));
                String harga = cursor.getString(cursor.getColumnIndex("harga"));

                databarang.add(new Barang(idbarang,barang,stok,harga));
            }
            adapter = new BarangAdapter(this,databarang);
            rcvBarang.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else{
            pesan("Data Kosong");
        }
    }

    public void deleteData (String id){
        idbarang = id;

        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setTitle("PERINGATAN !");
        al.setMessage("Anda yakin ingin menghapus data ini?");
        al.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String sql = "DELETE FROM tblbarang WHERE idbarang = "+idbarang+"";
                if (db.runSQL(sql)){
                    pesan("data telah dihapus");
                    selectData();
                }else{
                    pesan("data gagal dihapus");
                }
            }
        });

        al.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        al.show();

    }

    public void selectUpdate(String id){
        idbarang = id;
        String sql = "SELECT * FROM tblbarang WHERE idbarang = "+id+";";
        Cursor cursor = db.select(sql);
        cursor.moveToNext();

        etBarang.setText(cursor.getString(cursor.getColumnIndex("barang")));
        etStok.setText(cursor.getString(cursor.getColumnIndex("stok")));
        etHarga.setText(cursor.getString(cursor.getColumnIndex("harga")));

        tvPilihan.setText("Update");
    }
}