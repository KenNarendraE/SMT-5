package com.kenn.renton;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    public static String url = "http://192.168.100.4:8081/";
    public static Service service (){
        Retrofit r = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        Service s = r.create(Service.class);
        return s;
    }
}
