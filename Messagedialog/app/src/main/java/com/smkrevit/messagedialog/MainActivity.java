package com.smkrevit.messagedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast (String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    public void showAlert(String pesan){
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("perhatian");
        buatAlert.setMessage(pesan);

        buatAlert.show();
    }
    public void showAlertButton(String pesan){
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);
        showAlert.setTitle("peringatan");
        showAlert.setMessage(pesan);

        showAlert.setPositiveButton("ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("anda benar");
            }
        });

        showAlert.setNegativeButton("tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("anda salah");
            }
        });

        showAlert.show();
    }

    public void btnToast(View view) {
        showToast("belajar toaast");
    }

    public void btnAlert(View view) {
        showAlert("ini alert");
    }

    public void btnAlertDialogButton(View view) {
        showAlertButton("pilihan ada di tangan anda");
    }
}