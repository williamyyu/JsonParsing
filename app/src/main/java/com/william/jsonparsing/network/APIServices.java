package com.william.jsonparsing.network;

import com.william.jsonparsing.pojos.Users;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {

    @GET("users")
    Call<Users> getUsers();
}
