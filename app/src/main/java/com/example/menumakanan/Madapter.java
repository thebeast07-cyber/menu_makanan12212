package com.example.menumakanan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Madapter extends RecyclerView.Adapter<Madapter.Mviewholder> {

    String data1[],data2[],data3[];
    int gambar[];
    Context context;
    private Mviewholder mviewholder;
    private int position;

    public Madapter (Context ct, String nam[], String desk[], String harg[], int gamb[]){
        context = ct;
        data1 = nam;
        data2 = desk;
        data3 = harg;
        gambar = gamb;

    }

    @NonNull
    @Override
    public Mviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.baris_makanan,parent,false);
        return new Mviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mviewholder mviewholder, int position) {
        this.mviewholder = mviewholder;
        this.position = position;
        mviewholder.tx_nama.setText(data1[position]);
        mviewholder.tx_harga.setText(data3[position]);
        mviewholder.mygambar.setImageResource(gambar[position]);

        mviewholder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , ActivityKedua.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("data3",data3[position]);
                intent.putExtra("mygambar",gambar[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class Mviewholder extends RecyclerView.ViewHolder {

        TextView tx_nama,tx_harga;
        ImageView mygambar;
        ConstraintLayout mainlayout;

        public Mviewholder(@NonNull View itemView) {
            super(itemView);
            tx_nama = itemView.findViewById(R.id.tx_nama);
            tx_harga = itemView.findViewById(R.id.tx_harga);
            mygambar = itemView.findViewById(R.id.mygambar);
            mainlayout = itemView.findViewById(R.id.mainlayput);
        }
    }
}
