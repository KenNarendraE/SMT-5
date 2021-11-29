package com.kenn.renton.model;

public class UserModel {
    private Integer id;
    private String pengguna,email,password,alamat,telp,umur,status;

    public UserModel(Integer id, String pengguna, String email, String password, String alamat, String telp, String umur, String status) {
        this.id = id;
        this.pengguna = pengguna;
        this.email = email;
        this.password = password;
        this.alamat = alamat;
        this.telp = telp;
        this.umur = umur;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPengguna() {
        return pengguna;
    }

    public void setPengguna(String pengguna) {
        this.pengguna = pengguna;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
