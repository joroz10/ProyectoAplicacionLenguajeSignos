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
import com.example.proyectoaplicacionlenguajesignos.Utils;
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
        Utils utils = new Utils();
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        btnCategoria = (Button) findViewById(R.id.btnPorCategoria);
        btnPalabra = (Button) findViewById(R.id.btnPorPalabra);
        List list = new ArrayList();
        list = utils.rellenar();

        realm.beginTransaction();
        realm.deleteAll();
        for (Object o:list) {
            Palabra p = (Palabra) o;
            realm.copyToRealmOrUpdate(p);
        }
        realm.commitTransaction();

        btnPalabra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityPalabras.class);
                startActivity(intent);
            }
        });
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