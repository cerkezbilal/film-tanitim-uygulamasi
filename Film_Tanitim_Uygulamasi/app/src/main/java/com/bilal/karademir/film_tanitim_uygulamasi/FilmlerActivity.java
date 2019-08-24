package com.bilal.karademir.film_tanitim_uygulamasi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class FilmlerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView filmlerRv;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter adapter;
    Kategoriler kategori;
    Veritabani vt;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);

        toolbar = findViewById(R.id.toolbar);
        filmlerRv = findViewById(R.id.filmlerRv);


        vt = new Veritabani(context);
        kategori = (Kategoriler) getIntent().getSerializableExtra("kategori_nesne");
        toolbar.setTitle(kategori.getKategori_ad());
        setSupportActionBar(toolbar);
        filmlerArrayList = new FilmlerDao().tumFilmler(vt,kategori.getKategori_id());

        filmlerRv.setHasFixedSize(true);
        filmlerRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));



        adapter = new FilmlerAdapter(this,filmlerArrayList);

        filmlerRv.setAdapter(adapter);



    }
}
