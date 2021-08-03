package com.smkrevit.konversisuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText etNilai;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    load();
    }

    public void load(){
        spinner = findViewById(R.id.spinner);
        tvHasil = findViewById(R.id.tvHasil);
        etNilai = findViewById(R.id.etNilai);
    }

    /*
    public void isiSpinner(){
        String[] isi = {"Celsius To Reamur", "Celsius To Fahrenheit", "Celsius To Kelvin", "Reamur To Celsius", "Reamur To Fahrenheit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,isi);
        spinner.setAdapter(adapter);
    }
     */

    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();
        if (etNilai.getText().toString().equals("")){
            Toast.makeText(this, "Input Kosong", Toast.LENGTH_SHORT).show();
        }else{
            if (pilihan.equals("Celsius To Reamur")){
                cTOr();
            }
            if (pilihan.equals("Celsius To Fahrenheit")){
                cTOf();
            }
            if (pilihan.equals("Celsius To Kelvin")){
                cTOk();
            }
            if (pilihan.equals("Reamur To Celsius")){
                rTOc();
            }
            if (pilihan.equals("Reamur To Fahrenheit")){
                rTOf();
            }
        }


    }

    public void cTOr(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (4.0/5.0) * suhu;
        tvHasil.setText(hasil+"");

    }
    public void cTOf(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (9.0/5.0) * suhu + 32.0;
        tvHasil.setText(hasil+"");

    }
    public void cTOk(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = suhu +  273.15;
        tvHasil.setText(hasil+"");

    }
    public void rTOc(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (5.0/4.0) * suhu;
        tvHasil.setText(hasil+"");

    }
    public void rTOf(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = suhu * 2.25 + 32;
        tvHasil.setText(hasil+"");

    }
}