package com.kelompokamalia.wowtechno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBukuAdapter extends ArrayAdapter<Buku>{
    public  CustomBukuAdapter(Context context, ArrayList<Buku> bukus){
        super(context, 0, bukus);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Buku buku = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_buku, parent, false);
        }

        TextView textJudulBuku = (TextView) convertView.findViewById(R.id.textJudulBuku);
        TextView textNamaPengarang = (TextView) convertView.findViewById(R.id.textNamaPengarang);
        TextView textJumlahHalaman = (TextView) convertView.findViewById(R.id.textJumlahHalaman);

        textJudulBuku.setText(buku.judulBuku);
        textNamaPengarang.setText(buku.namaPengarang);
        textJumlahHalaman.setText(buku.jumlahHalaman);

        return convertView;
    }
}
