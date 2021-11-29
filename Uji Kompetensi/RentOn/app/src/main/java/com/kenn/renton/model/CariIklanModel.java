package com.kenn.renton.model;

import com.google.gson.annotations.SerializedName;

public class CariIklanModel {
    @SerializedName("id")
    private String idiklan;

    @SerializedName("harga")
    private String harga;

    @SerializedName("judul")
    private String nama;

    @SerializedName("alamat")
    private String lokasi;

    @SerializedName("waktumin")
    private String waktu;

    @SerializedName("id_pengguna")
    private String idpengguna;

    @SerializedName("kategori")
    private String kategori;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("waktumax")
    private String waktumax;

    @SerializedName("gambar")
    private String gambar;

    @SerializedName("telp")
    private String telp;


    public String getIdpengguna() {
        return idpengguna;
    }

    public void setIdpengguna(String idpengguna) {
        this.idpengguna = idpengguna;
    }

    public CariIklanModel(String harga, String nama, String lokasi, String waktu, String kategori, String deskripsi, String waktumax, String gambar, String telp) {
        this.harga = harga;
        this.nama = nama;
        this.lokasi = lokasi;
        this.waktu = waktu;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
        this.waktumax = waktumax;
        this.gambar = gambar;
        this.telp = telp;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKategori() {
        return kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getWaktumax() {
        return waktumax;
    }

    public String getIdiklan() {
        return idiklan;
    }

    public void setIdiklan(String idiklan) {
        this.idiklan = idiklan;
    }
    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
