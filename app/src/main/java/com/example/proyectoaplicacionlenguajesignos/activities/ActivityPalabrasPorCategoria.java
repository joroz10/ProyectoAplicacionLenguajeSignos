package com.example.proyectoaplicacionlenguajesignos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.proyectoaplicacionlenguajesignos.R;
import com.example.proyectoaplicacionlenguajesignos.adapters.PalabraAdapter;
import com.example.proyectoaplicacionlenguajesignos.models.Palabra;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ActivityPalabrasPorCategoria extends AppCompatActivity {
    RecyclerView rcvCategoria;
    TextView lblCategoria;
    Realm realm;
    PalabraAdapter palabraAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras_por_categoria);
        Bundle bundle = getIntent().getExtras();
        Realm.init(this.getBaseContext());
        realm = Realm.getDefaultInstance();
        String categoria = bundle.getString("categoria");
        List list = new ArrayList();
        List<Palabra> palabras = new ArrayList();

        rcvCategoria = (RecyclerView) findViewById(R.id.rcvPalabrasCaegoria);
        lblCategoria = (TextView) findViewById(R.id.lblCategoria);
        lblCategoria.setText(categoria);

        palabras = realm.where(Palabra.class).findAll();
        for (Palabra p:palabras){
            String strCategoria = p.getCategoria();
            if ( strCategoria.equals(categoria)){
                list.add(p);
            }
        }

        palabraAdapter = new PalabraAdapter(list, new PalabraAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Palabra p, int position) {

            }
        });
        rcvCategoria.setAdapter(palabraAdapter);
        rcvCategoria.setLayoutManager(new GridLayoutManager(this,2));

    }
}