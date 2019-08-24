package com.bilal.karademir.film_tanitim_uygulamasi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView kategoriRv;
    Context context = this;
    ArrayList<Kategoriler> kategorilerArrayList;
    KategoriAdapter adapter;
    Veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        kategoriRv = findViewById(R.id.kategoriRv);
        veriTabaniKopyala();

        toolbar.setTitle("Kategoriler");
        setSupportActionBar(toolbar);

        kategoriRv.setHasFixedSize(true);
        kategoriRv.setLayoutManager(new LinearLayoutManager(context));
        vt = new Veritabani(context);


        kategorilerArrayList = new KategorilerDao().tumKategoriler(vt);


        adapter = new KategoriAdapter(context,kategorilerArrayList);
        kategoriRv.setAdapter(adapter);


    }

    public void veriTabaniKopyala(){
        DatabaseCopyHelper helper = new DatabaseCopyHelper(context);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.openDataBase();
    }
}
