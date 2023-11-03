package com.example.proyectoaplicacionlenguajesignos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyectoaplicacionlenguajesignos.R;
import com.example.proyectoaplicacionlenguajesignos.adapters.PalabraAdapter;
import com.example.proyectoaplicacionlenguajesignos.models.Palabra;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PalabraAdapter recyclerDataAdapter;
    Realm realm;
    Button btnCategoria;
    Button btnPalabra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        btnCategoria = (Button) findViewById(R.id.btnPorCategoria);

        realm.beginTransaction();
        realm.deleteAll();
        realm.copyToRealmOrUpdate(new Palabra("Boca",R.drawable.boca,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Brazo",R.drawable.brazo,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Cabeza",R.drawable.cabeza,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Cuerpo",R.drawable.cuerpo,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Culo",R.drawable.culo,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Dedo",R.drawable.dedo,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Dientes",R.drawable.dientes,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Lengua",R.drawable.lengua,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Mano",R.drawable.mano,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Nariz",R.drawable.nariz,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Ojo",R.drawable.ojo,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Oreja",R.drawable.oreja,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Pelo",R.drawable.pelo,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Pene",R.drawable.pene,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Pie",R.drawable.pie,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Pierna",R.drawable.pierna,"Cuerpo","Cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Vulva",R.drawable.vulva,"Cuerpo","Cuerpo"));

        realm.copyToRealmOrUpdate(new Palabra("Gusto",R.drawable.gusto,"Cuerpo","Sentido"));
        realm.copyToRealmOrUpdate(new Palabra("Oido",R.drawable.oido,"Cuerpo","Sentido"));
        realm.copyToRealmOrUpdate(new Palabra("Olfato",R.drawable.olfato,"Cuerpo","Sentido"));
        realm.copyToRealmOrUpdate(new Palabra("Sentidos",R.drawable.sentidos,"Cuerpo","Sentido"));
        realm.copyToRealmOrUpdate(new Palabra("Tacto",R.drawable.tacto,"Cuerpo","Sentido"));
        realm.copyToRealmOrUpdate(new Palabra("Vista",R.drawable.vista,"Cuerpo","Sentido"));
        realm.commitTransaction();

        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityCategorias.class);
                startActivity(intent);
            }
        });
        /*List list = new ArrayList();
        list = realm.where(Palabra.class).findAll();

        recyclerDataAdapter = new PalabraAdapter(list, new PalabraAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(Palabra p, int position) {
                Toast.makeText(MainActivity.this, p.palabra, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(recyclerDataAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));*/
    }
}