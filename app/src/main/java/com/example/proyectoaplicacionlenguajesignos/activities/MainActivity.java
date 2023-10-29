package com.example.proyectoaplicacionlenguajesignos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.proyectoaplicacionlenguajesignos.R;
import com.example.proyectoaplicacionlenguajesignos.adapters.RecyclerDataAdapter;
import com.example.proyectoaplicacionlenguajesignos.models.Palabra;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerDataAdapter recyclerDataAdapter;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();

        recyclerView = (RecyclerView) findViewById(R.id.rcvMain);


        realm.beginTransaction();
        realm.deleteAll();
        realm.copyToRealmOrUpdate(new Palabra("Boca",R.drawable.boca,"cuerpo","cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Brazo",R.drawable.brazo,"cuerpo","cuerpo"));
        realm.copyToRealmOrUpdate(new Palabra("Cabeza",R.drawable.cabeza,"cuerpo","cuerpo"));
        realm.commitTransaction();

        List list = new ArrayList();
        list = realm.where(Palabra.class).findAll();

        recyclerDataAdapter = new RecyclerDataAdapter(list, new RecyclerDataAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(Palabra p, int position) {
                Toast.makeText(MainActivity.this, p.palabra, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(recyclerDataAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
}