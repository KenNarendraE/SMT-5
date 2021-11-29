package com.kenn.renton.model;

import java.util.Date;

public class LoginModel {
    private String pesan,token;
    private UserModel data;

    public UserModel getData() {
        return data;
    }

    public void setData(UserModel data) {
        this.data = data;
    }

    public LoginModel(String pesan, String token, UserModel data) {
        this.pesan = pesan;
        this.token = token;
        this.data = data;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

class Data{
    private Integer id;
    private String pengguna,email,password,alamat,telp,umur,status;

    public Data(Integer id, String pengguna, String email, String password, String alamat, String telp, String umur, String status) {
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


