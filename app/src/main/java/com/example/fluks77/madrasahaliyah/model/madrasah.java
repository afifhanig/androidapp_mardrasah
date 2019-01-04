package com.example.fluks77.madrasahaliyah.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class madrasah implements Serializable {

    @SerializedName("id")
    private String idMadrasah;
    @SerializedName("nama_instansi")
    private String namaMadrasah;
    @SerializedName("alamat_instansi")
    private String alamat;
    @SerializedName("latitude")
    private String lat;
    @SerializedName("longitude")
    private String lang;
    @SerializedName("jenis")
    private String jmadrasah;


    public madrasah(String idMadrasah, String namaMadrasah, String alamat, String lat, String lang, String jmadrasah) {
        this.idMadrasah = idMadrasah;
        this.namaMadrasah = namaMadrasah;
        this.alamat = alamat;
        this.lat = lat;
        this.lang = lang;
        this.jmadrasah = jmadrasah;
    }


    public String getIdMadrasah() {
        return idMadrasah;
    }

    public String getNamaMadrasah() {
        return namaMadrasah;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getLat() {
        return lat;
    }

    public String getLang() {
        return lang;
    }

    public String getJmadrasah() {
        return jmadrasah;
    }
}
