package com.william.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.william.jsonparsing.network.APIClient;
import com.william.jsonparsing.network.APIServices;
import com.william.jsonparsing.pojos.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIClient.retrofit(APIServices.class).getUsers().enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                String test = "";
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
    }
}
