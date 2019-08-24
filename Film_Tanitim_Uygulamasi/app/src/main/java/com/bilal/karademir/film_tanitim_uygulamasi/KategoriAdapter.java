package com.bilal.karademir.film_tanitim_uygulamasi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class KategoriAdapter extends  RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu>{
    private Context context;
    private List<Kategoriler> kategorilerListe;

    public KategoriAdapter(Context context, List<Kategoriler> kategorilerListe) {
        this.context = context;
        this.kategorilerListe = kategorilerListe;
    }


    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardView kategori_card;
        private TextView textViewKategoriAd;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            kategori_card = itemView.findViewById(R.id.kategori_card);
            textViewKategoriAd = itemView.findViewById(R.id.textViewKategoriAd);

        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kategori_card_tasarim,viewGroup,false);

        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu cardTasarimTutucu, final int i) {

        final Kategoriler kategori = kategorilerListe.get(i);
        cardTasarimTutucu.textViewKategoriAd.setText(kategori.getKategori_ad());
        cardTasarimTutucu.kategori_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(context,FilmlerActivity.class);
                    intent.putExtra("kategori_nesne",kategori);
                    context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kategorilerListe.size();
    }

}
