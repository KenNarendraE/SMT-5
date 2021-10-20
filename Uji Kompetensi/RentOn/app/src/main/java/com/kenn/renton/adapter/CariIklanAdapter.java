package com.kenn.renton.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kenn.renton.DetailIklanActivity;
import com.kenn.renton.MainActivity;
import com.kenn.renton.R;
import com.kenn.renton.RegisterActivity;
import com.kenn.renton.model.CariIklanModel;

import java.util.ArrayList;

public class CariIklanAdapter extends RecyclerView.Adapter<CariIklanAdapter.CariIklanViewHolder> {

    private ArrayList<CariIklanModel> listIklan;
    private Context context;

    public CariIklanAdapter(ArrayList<CariIklanModel> listIklan, Context context) {
        this.listIklan = listIklan;
        this.context = context;
    }

    @NonNull
    @Override
    public CariIklanAdapter.CariIklanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_cari_iklan,parent, false);
        return new CariIklanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CariIklanAdapter.CariIklanViewHolder holder, int position) {
        holder.tvHarga.setText(listIklan.get(position).getHarga());
        holder.tvNama.setText(listIklan.get(position).getNama());
        holder.tvLokasi.setText(listIklan.get(position).getLokasi());
        holder.tvWaktu.setText(listIklan.get(position).getWaktu());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailIklanActivity.class);
                intent.putExtra("harga",listIklan.get(position).getHarga());
                intent.putExtra("nama",listIklan.get(position).getNama());
                intent.putExtra("lokasi",listIklan.get(position).getLokasi());
                intent.putExtra("waktu",listIklan.get(position).getWaktu());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (listIklan!=null) ? listIklan.size() : 0;
    }

    public class CariIklanViewHolder extends RecyclerView.ViewHolder{

        private TextView tvHarga, tvNama, tvLokasi, tvWaktu;
        LinearLayout item;

        public CariIklanViewHolder (View view){
            super(view);

            item = view.findViewById(R.id.item);
            tvHarga = view.findViewById(R.id.tvHarga);
            tvNama = view.findViewById(R.id.tvNama);
            tvLokasi = view.findViewById(R.id.tvLokasi);
            tvWaktu = view.findViewById(R.id.tvWaktu);
        }
    }


}
