package com.william.jsonparsing;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.william.jsonparsing.database.AppDatabase;
import com.william.jsonparsing.database.pojos.Data;
import com.william.jsonparsing.database.pojos.DataList;
import com.william.jsonparsing.network.APIClient;
import com.william.jsonparsing.network.APIServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mAppDatabase;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mAppDatabase = AppDatabase.getAppDatabase(this);

        // for test
        fetchDataFromJsonFile();

//        you need to change the URL in APIServices
//        fetchDataFromServer();
    }

    private void fetchDataFromJsonFile() {
        try {
            String jsonString = readJson();
            final DataList dataList = new Gson().fromJson(jsonString, DataList.class);

            List<Data> list = new ArrayList<>(dataList.getData());
            insertData(list);
            setRecyclerView(MainActivity.this, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fetchDataFromServer() {
        APIClient.retrofit(APIServices.class).getData().enqueue(new Callback<DataList>() {
            @Override
            public void onResponse(Call<DataList> call, Response<DataList> response) {
                List<Data> list = response.body().getData();
                insertData(list);

                setRecyclerView(MainActivity.this, list);
            }

            @Override
            public void onFailure(Call<DataList> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView(Context context, List<Data> list) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(context, list);
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    private void loadAllDataFromDatabase() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Data> data = mAppDatabase.dataDao().getAll();
            }
        });
    }

    private void insertData(final List<Data> dataList) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                for (Data data : dataList) {
                    mAppDatabase.dataDao().insertAll(data);
                }
            }
        });
    }

    private void deleteData(final List<Data> dataList) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                for (Data data : dataList) {
                    mAppDatabase.dataDao().delete(data);
                }
            }
        });
    }

    private String readJson() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("TestFile.json"), "UTF-8"));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }

        return content.toString();
    }
}