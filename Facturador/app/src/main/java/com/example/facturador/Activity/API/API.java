package com.example.facturador.Activity.API;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public static Retrofit retrofit = null;
    public static String BASE_URL = "http://192.168.0.8:82";



    public static Retrofit getAPI(GsonBuilder builder) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }
}
