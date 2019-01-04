package com.example.fluks77.madrasahaliyah.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.fluks77.madrasahaliyah.R;
import com.example.fluks77.madrasahaliyah.adapter.RVadapter;
import com.example.fluks77.madrasahaliyah.model.ResponseMadrasah;
import com.example.fluks77.madrasahaliyah.model.madrasah;

import java.util.ArrayList;
import java.util.List;

import static com.example.fluks77.madrasahaliyah.Constant.BASE_URL;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    List<madrasah> listMadrasah;
    RVadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        AndroidNetworking.initialize(getApplicationContext());

        initRecylerView();
    }

    private void initRecylerView(){
        listMadrasah = new ArrayList<>();
        adapter = new RVadapter(this, listMadrasah);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.hasFixedSize();

        loadItems();
    }
    private void loadItems(){
        AndroidNetworking.get(BASE_URL + "madrasah")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(ResponseMadrasah.class, new ParsedRequestListener<ResponseMadrasah>(){

                    @Override
                    public void onResponse(ResponseMadrasah response) {
                        List<madrasah> data = response.getData();
                        if (data != null) {
                            Log.e("RESPONSE", "" + response.toString());
                            listMadrasah.addAll(data);
                            adapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(MainActivity.this, "Data kosong !", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(MainActivity.this, "Cannot load data !", Toast.LENGTH_SHORT).show();
                    }
                });
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            Intent intent = new Intent(getApplicationContext(), AboutAct.class);
            startActivity(intent);
        }
        return true;
    }
}



