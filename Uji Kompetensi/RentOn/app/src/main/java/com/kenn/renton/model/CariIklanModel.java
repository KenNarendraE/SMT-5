package com.kenn.renton.model;

public class CariIklanModel {
    private String harga;
    private String nama;
    private String lokasi;
    private String waktu;

    public CariIklanModel(String harga, String nama, String lokasi, String waktu) {
        this.harga = harga;
        this.nama = nama;
        this.lokasi = lokasi;
        this.waktu = waktu;
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
