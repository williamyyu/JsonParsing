package com.william.jsonparsing.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final String BASE_URL = "https://reqres.in/api/";

    private static final OkHttpClient sOkHttpClient = new OkHttpClient.Builder().build();

    public static <T> T retrofit(Class<T> serviceClazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(sOkHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClazz);
    }
}
