package com.example.proyectoaplicacionlenguajesignos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.proyectoaplicacionlenguajesignos.R;
import com.example.proyectoaplicacionlenguajesignos.adapters.PalabraAdapter;
import com.example.proyectoaplicacionlenguajesignos.models.Palabra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.realm.Realm;
import io.realm.Sort;

public class ActivityPalabras extends AppCompatActivity {

    Realm realm;
    EditText buscador;
    RecyclerView rcvBuscador;
    PalabraAdapter palabraAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras);
        realm = Realm.getDefaultInstance();
        buscador = (EditText) findViewById(R.id.etBuscador);
        rcvBuscador = (RecyclerView) findViewById(R.id.rcvBuscador);
        List palabras;

        palabras = realm.where(Palabra.class).sort("palabra", Sort.ASCENDING)
                .findAll();;

        palabraAdapter =new PalabraAdapter(palabras, new PalabraAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Palabra p, int position) {
                Intent intent = new Intent(ActivityPalabras.this,ActivityVerPalabra.class);
                intent.putExtra("palabra",p.getPalabra());
                intent.putExtra("imagen",p.getDrawable());
                intent.putExtra("subcategoria",p.getSubcategoria());
                startActivity(intent);
            }
        });

        rcvBuscador.setAdapter(palabraAdapter);
        rcvBuscador.setLayoutManager(new GridLayoutManager(this,2));




        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                List palabrasBuscador = new ArrayList();
                for (Object o:palabras) {
                    Palabra p = (Palabra) o;
                    if(p.palabra.toLowerCase().contains(buscador.getText().toString())){
                        palabrasBuscador.add(p);
                    }
                }

                palabraAdapter =new PalabraAdapter(palabrasBuscador, new PalabraAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Palabra p, int position) {
                        Intent intent = new Intent(ActivityPalabras.this,ActivityVerPalabra.class);
                        intent.putExtra("palabra",p.getPalabra());
                        intent.putExtra("imagen",p.getDrawable());
                        intent.putExtra("subcategoria",p.getSubcategoria());
                        startActivity(intent);
                    }
                });
                rcvBuscador.setAdapter(palabraAdapter);
                rcvBuscador.setLayoutManager(new GridLayoutManager(ActivityPalabras.this,2));
            }
        });
    }
}