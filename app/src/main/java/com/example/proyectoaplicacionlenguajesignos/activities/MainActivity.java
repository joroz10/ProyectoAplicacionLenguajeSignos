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
        realm.copyToRealmOrUpdate(new Palabra("Boca",R.drawable.boca,"cuerpo","cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Brazo",R.drawable.brazo,"cuerpo","cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Cabeza",R.drawable.cabeza,"cuerpo","cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Cuerpo",R.drawable.cuerpo,"cuerpo","cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Culo",R.drawable.culo,"cuerpo","cuerpo"));
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