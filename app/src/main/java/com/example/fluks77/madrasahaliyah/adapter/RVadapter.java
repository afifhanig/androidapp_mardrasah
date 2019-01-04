package com.example.fluks77.madrasahaliyah.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fluks77.madrasahaliyah.R;
import com.example.fluks77.madrasahaliyah.activity.DetailMadrasah;
import com.example.fluks77.madrasahaliyah.activity.MainActivity;
import com.example.fluks77.madrasahaliyah.model.madrasah;

import java.util.List;

public class RVadapter extends RecyclerView.Adapter<RVadapter.ViewHolder>  {

    Context context;
    List<madrasah> listMadrasah;

    public RVadapter(Context context, List<madrasah> listMadrasah) {
        this.context = context;
        this.listMadrasah = listMadrasah;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_madrasah, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final madrasah aliyah = listMadrasah.get(i);
        viewHolder.t3.setText(aliyah.getIdMadrasah());
        viewHolder.t1.setText(aliyah.getNamaMadrasah());
        viewHolder.t2.setText(aliyah.getAlamat());

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMadrasah.class);
                intent.putExtra("namamadrasah", aliyah.getNamaMadrasah());
                intent.putExtra("alamatmadrasah", aliyah.getAlamat());
                intent.putExtra("latitude", aliyah.getLat());
                intent.putExtra("langitude", aliyah.getLang());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMadrasah.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView t1;
        TextView t2;
        TextView t3;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.nama_m );
            t2=itemView.findViewById(R.id.alamat );
            t3=itemView.findViewById(R.id.idmadrasah);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }

}
