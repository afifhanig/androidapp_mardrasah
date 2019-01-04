package com.example.fluks77.madrasahaliyah.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.net.Uri;

import com.example.fluks77.madrasahaliyah.R;

public class DetailMadrasah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_madrasah);
        terimadata();
    }

    private void terimadata(){
        if(getIntent().hasExtra("namamadrasah")&& getIntent().hasExtra("alamatmadrasah")&&getIntent().hasExtra("latitude")&&getIntent().hasExtra("langitude")){
            String nm = getIntent().getStringExtra("namamadrasah");
            String am = getIntent().getStringExtra("alamatmadrasah");
            String latitude = getIntent().getStringExtra("latitude");
            String longitude = getIntent().getStringExtra("langitude");
            setall(nm, am, latitude, longitude);
        }
    }

    private void setall(String nm, String am, final String latitude, final String longitude){
        TextView tm1 = findViewById(R.id.nama_madrasah);
        tm1.setText(nm);
        TextView tm2 = findViewById(R.id.alamat_madrasah);
        tm2.setText(am);
        Button bt1 = findViewById(R.id.tombolmap);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?daddr=" + latitude + "," + longitude;
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
