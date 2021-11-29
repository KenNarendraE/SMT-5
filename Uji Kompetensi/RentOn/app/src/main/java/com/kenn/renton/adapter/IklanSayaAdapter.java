package com.kenn.renton.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kenn.renton.DetailIklanActivity;
import com.kenn.renton.DetailIklanSayaActivity;
import com.kenn.renton.R;
import com.kenn.renton.model.CariIklanModel;

import java.util.ArrayList;

public class IklanSayaAdapter extends RecyclerView.Adapter<IklanSayaAdapter.CariIklanViewHolder> {

    private ArrayList<CariIklanModel> listIklan;
    private Context context;

    public IklanSayaAdapter(ArrayList<CariIklanModel> listIklan, Context context) {
        this.listIklan = listIklan;
        this.context = context;
    }

    @NonNull
    @Override
    public IklanSayaAdapter.CariIklanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_cari_iklan,parent, false);
        return new CariIklanViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull IklanSayaAdapter.CariIklanViewHolder holder, int position) {
        holder.tvHarga.setText(listIklan.get(position).getHarga());
        holder.tvNama.setText(listIklan.get(position).getNama());
        holder.tvLokasi.setText(listIklan.get(position).getLokasi());
        holder.tvWaktu.setText(listIklan.get(position).getWaktu());
        holder.tvGambar.setText(listIklan.get(position).getGambar());
        Glide.with(context).load("http://192.168.100.4:8081/upload/"+listIklan.get(position).getGambar()).into(holder.imGambar);

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailIklanSayaActivity.class);
                intent.putExtra("idiklan",listIklan.get(position).getIdiklan());
                intent.putExtra("harga",listIklan.get(position).getHarga());
                intent.putExtra("nama",listIklan.get(position).getNama());
                intent.putExtra("lokasi",listIklan.get(position).getLokasi());
                intent.putExtra("waktu",listIklan.get(position).getWaktu());
                intent.putExtra("waktumax",listIklan.get(position).getWaktumax());
                intent.putExtra("deskripsi",listIklan.get(position).getDeskripsi());
                intent.putExtra("gambar",listIklan.get(position).getGambar());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (listIklan!=null) ? listIklan.size() : 0;
    }

    public class CariIklanViewHolder extends RecyclerView.ViewHolder{

        private TextView tvHarga, tvNama, tvLokasi, tvWaktu, tvGambar;
        ImageView imGambar;
        LinearLayout item;

        public CariIklanViewHolder (View view){
            super(view);

            item = view.findViewById(R.id.item);
            tvHarga = view.findViewById(R.id.tvHarga);
            tvNama = view.findViewById(R.id.tvNama);
            tvLokasi = view.findViewById(R.id.tvLokasi);
            tvWaktu = view.findViewById(R.id.tvWaktu);
            tvGambar = view.findViewById(R.id.tvGambar);
            imGambar = view.findViewById(R.id.imGambar);
        }
    }


}
