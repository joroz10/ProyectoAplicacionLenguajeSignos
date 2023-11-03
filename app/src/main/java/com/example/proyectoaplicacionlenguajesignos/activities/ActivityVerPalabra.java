package com.example.proyectoaplicacionlenguajesignos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectoaplicacionlenguajesignos.R;
import com.example.proyectoaplicacionlenguajesignos.adapters.PalabraAdapter;
import com.example.proyectoaplicacionlenguajesignos.models.Palabra;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ActivityVerPalabra extends AppCompatActivity {

    TextView lblPalabra;
    ImageView imgPalabra;
    RecyclerView rcvSubcategoria;
    Realm realm;
    PalabraAdapter palabraAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_palabra);
        Bundle bundle = getIntent().getExtras();
        Realm.init(this.getBaseContext());
        realm = Realm.getDefaultInstance();

        lblPalabra = (TextView) findViewById(R.id.lblPalabra);
        imgPalabra = (ImageView) findViewById(R.id.imgPalabra);
        rcvSubcategoria = (RecyclerView) findViewById(R.id.rcvPalabra);

        List list = new ArrayList();
        List<Palabra> palabras = new ArrayList();

        String palabra = bundle.getString("palabra");
        lblPalabra.setText(palabra);
        Integer img = bundle.getInt("imagen");
        imgPalabra.setImageResource(img);

        String subcategoria = bundle.getString("subcategoria");
        palabras = realm.where(Palabra.class).findAll();
        for (Palabra p:palabras){
            String strCategoria = p.getSubcategoria();
            if ( strCategoria.equals(subcategoria)){
                list.add(p);
            }
        }
        palabraAdapter = new PalabraAdapter(list, new PalabraAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Palabra p, int position) {
                finish();
                Intent intent = new Intent(ActivityVerPalabra.this,ActivityVerPalabra.class);
                intent.putExtra("palabra",p.getPalabra());
                intent.putExtra("imagen",p.getDrawable());
                intent.putExtra("subcategoria",p.getSubcategoria());
                startActivity(intent);
            }
        });
        rcvSubcategoria.setAdapter(palabraAdapter);
        rcvSubcategoria.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }
}