package com.william.jsonparsing.database.pojos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Data {

    @SerializedName("data_time")
    @android.support.annotation.NonNull
    @PrimaryKey()
    @ColumnInfo(name = "data_time")
    private String dataTime = "";

    @SerializedName("data_6")
    @ColumnInfo(name = "data_6")
    private String data6;

    @SerializedName("data_22")
    @ColumnInfo(name = "data_22")
    private String data22;

    @SerializedName("data_65")
    @ColumnInfo(name = "data_65")
    private String data65;

    @SerializedName("data_183")
    @ColumnInfo(name = "data_183")
    private String data183;

    @SerializedName("data_59")
    @ColumnInfo(name = "data_59")
    private String data59;

    @SerializedName("data_186")
    @ColumnInfo(name = "data_186")
    private String data186;

    @SerializedName("data_184")
    @ColumnInfo(name = "data_184")
    private String data184;

    @SerializedName("data_185")
    @ColumnInfo(name = "data_185")
    private String data185;

    public void setData6(String data6) {
        this.data6 = data6;
    }

    public String getData6() {
        return data6;
    }

    public void setData22(String data22) {
        this.data22 = data22;
    }

    public String getData22() {
        return data22;
    }

    public void setData65(String data65) {
        this.data65 = data65;
    }

    public String getData65() {
        return data65;
    }

    public void setData183(String data183) {
        this.data183 = data183;
    }

    public String getData183() {
        return data183;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setData59(String data59) {
        this.data59 = data59;
    }

    public String getData59() {
        return data59;
    }

    public void setData186(String data186) {
        this.data186 = data186;
    }

    public String getData186() {
        return data186;
    }

    public void setData184(String data184) {
        this.data184 = data184;
    }

    public String getData184() {
        return data184;
    }

    public void setData185(String data185) {
        this.data185 = data185;
    }

    public String getData185() {
        return data185;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "data_6 = '" + data6 + '\'' +
                        ",data_22 = '" + data22 + '\'' +
                        ",data_65 = '" + data65 + '\'' +
                        ",data_183 = '" + data183 + '\'' +
                        ",data_time = '" + dataTime + '\'' +
                        ",data_59 = '" + data59 + '\'' +
                        ",data_186 = '" + data186 + '\'' +
                        ",data_184 = '" + data184 + '\'' +
                        ",data_185 = '" + data185 + '\'' +
                        "}";
    }
}