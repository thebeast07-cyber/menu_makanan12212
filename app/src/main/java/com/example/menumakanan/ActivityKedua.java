package com.example.menumakanan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityKedua extends AppCompatActivity {
    ImageView mgambar;
    TextView nama,deskripsi,harga;

    String data1,data2,data3;
    int mygambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        mgambar = findViewById(R.id.mgambar);
        nama = findViewById(R.id.nama);
        deskripsi = findViewById(R.id.deskripsi);
        harga = findViewById(R.id.harga);

        getdata();
        setdata();

    }
    private void getdata(){
        if(getIntent().hasExtra("mygambar") && getIntent().hasExtra("data1") && getIntent().
        hasExtra("data2") && getIntent().hasExtra("data3")){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            mygambar = getIntent().getIntExtra("mygambar", 1);

        }else {
            Toast.makeText(this,"Data Tidak Ada",Toast.LENGTH_SHORT).show();
        }
    }
    private void setdata(){
        nama.setText(data1);
        deskripsi.setText(data2);
        harga.setText(data3);
        mgambar.setImageResource(mygambar);
    }
}