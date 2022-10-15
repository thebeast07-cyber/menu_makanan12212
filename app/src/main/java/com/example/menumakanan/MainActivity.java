package com.example.menumakanan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycle;

    String nam[],desk[],harg[];
    int gambar[] = {R.drawable.nasgor,R.drawable.baso,R.drawable.ayamgoreng,R.drawable.ayambakar,
    R.drawable.ayamgeprek,R.drawable.migoreng,R.drawable.ikan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle = findViewById(R.id.recycle);

        nam = getResources().getStringArray(R.array.nama);
        desk = getResources().getStringArray(R.array.deskripsi);
        harg = getResources().getStringArray(R.array.harga);

        Madapter madapter = new Madapter(this, nam,desk,harg,gambar);
        recycle.setAdapter(madapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }
}