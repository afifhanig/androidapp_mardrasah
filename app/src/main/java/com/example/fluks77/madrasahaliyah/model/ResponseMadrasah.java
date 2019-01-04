package com.example.fluks77.madrasahaliyah.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMadrasah {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<madrasah> data;

    public String getStatus() {
        return status;
    }

    public List<madrasah> getData() {
        return data;
    }
}
