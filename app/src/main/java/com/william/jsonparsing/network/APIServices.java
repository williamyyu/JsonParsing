package com.william.jsonparsing.network;

import com.william.jsonparsing.database.pojos.DataList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {

    @GET("your url")
    Call<DataList> getData();
}
