package com.william.jsonparsing;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.william.jsonparsing.database.AppDatabase;
import com.william.jsonparsing.database.pojos.Data;
import com.william.jsonparsing.database.pojos.DataList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppDatabase = AppDatabase.getAppDatabase(this);

        try {
            String jsonString = readJson();
            final DataList dataList = new Gson().fromJson(jsonString, DataList.class);

            List<Data> list = new ArrayList<>(dataList.getData());
            insertData(list);
            loadAllDataFromDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        APIClient.retrofit(APIServices.class).getUsers().enqueue(new Callback<Users>() {
//            @Override
//            public void onResponse(Call<Users> call, Response<Users> response) {
//                String test = "";
//            }
//
//            @Override
//            public void onFailure(Call<Users> call, Throwable t) {
//
//            }
//        });
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
