package com.william.jsonparsing.database.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataList {

    @SerializedName("")
    private List<Data> mDataList;

    public void setData(List<Data> jsonMember) {
        this.mDataList = jsonMember;
    }

    public List<Data> getData() {
        return mDataList;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        " = '" + mDataList + '\'' +
                        "}";
    }
}