package com.example.proyectoaplicacionlenguajesignos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.proyectoaplicacionlenguajesignos.R;
import com.example.proyectoaplicacionlenguajesignos.adapters.CategoriaAdapter;
import com.example.proyectoaplicacionlenguajesignos.adapters.PalabraAdapter;
import com.example.proyectoaplicacionlenguajesignos.models.Palabra;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ActivityCategorias extends AppCompatActivity {
    RecyclerView recyclerView;
    CategoriaAdapter categoriaAdapter;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        realm = Realm.getDefaultInstance();
        recyclerView = findViewById(R.id.rcvCategorias);

        List listCategoria = new ArrayList();

        for (Object o:realm.where(Palabra.class).findAll()) {
            Palabra p = (Palabra) o;
            if (!listCategoria.contains(p.categoria)){
                listCategoria.add(p.categoria);
            }
        }
        categoriaAdapter = new CategoriaAdapter(listCategoria, new CategoriaAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(String s, int position) {
                Intent intent = new Intent(ActivityCategorias.this,ActivityPalabrasPorCategoria.class);
                intent.putExtra("categoria",s.toString());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(categoriaAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }
}