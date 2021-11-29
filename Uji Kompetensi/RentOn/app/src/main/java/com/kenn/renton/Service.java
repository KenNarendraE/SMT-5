package com.kenn.renton;

import com.kenn.renton.model.CariIklanModel;
import com.kenn.renton.model.LoginModel;
import com.kenn.renton.model.LoginForm;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Service {
    @GET("iklan")
    Call<ArrayList<CariIklanModel>> getData();

    @GET("api/iklan/me/2")
    Call<ArrayList<CariIklanModel>> getDataKu();

    @POST("api/iklan")
    Call<CariIklanModel> setData(@Body CariIklanModel iklan);

    @DELETE("api/iklan/{id}")
    Call<CariIklanModel> deleteData(@Path("id") String id);

    @PUT("api/iklan/{id}")
    Call<ArrayList<CariIklanModel>> deleteData(@Path("id") String id, @Body CariIklanModel iklan);

    @POST("login")
    Call<LoginModel> setLogin(@Body LoginForm login);
}
