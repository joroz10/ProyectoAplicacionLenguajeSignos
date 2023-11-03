package com.example.proyectoaplicacionlenguajesignos.models;

import com.example.proyectoaplicacionlenguajesignos.app.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Palabra extends RealmObject {
    @PrimaryKey
    private int id;
    public String palabra;
    public int drawable;
    public String categoria;
    public String subcategoria;
    public Palabra(){}
    public Palabra(String palabra, int drawable, String categoria, String subcategoria){
        this.id = MyApplication.elementId.getAndIncrement();
        this.palabra = palabra;
        this.drawable = drawable;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }
}