package com.bilal.karademir.film_tanitim_uygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {

    ImageView imageViewFilmResim;
    TextView textViewFilmAdi,textViewYil,textViewYonetmen;
    Filmler film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        imageViewFilmResim = findViewById(R.id.imageViewResim);
        textViewFilmAdi = findViewById(R.id.textViewFilmAd);
        textViewYil = findViewById(R.id.textViewYil);
        textViewYonetmen = findViewById(R.id.textViewYonetmen);

        film = (Filmler)getIntent().getSerializableExtra("nesne");
        textViewFilmAdi.setText(film.getFilm_ad());
        textViewYil.setText(String.valueOf(film.getFilm_yil()));
        textViewYonetmen.setText(film.getYonetmen().getYonetmen_ad());
        imageViewFilmResim.setImageResource(getResources().getIdentifier(film.getFilm_resim(),"drawable",getPackageName()));




    }
}
