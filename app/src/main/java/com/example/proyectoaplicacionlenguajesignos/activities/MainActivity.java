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
        realm.copyToRealmOrUpdate(new Palabra("Alfombra",R.drawable.alfombra,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Armario",R.drawable.armario,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Baño",R.drawable.bano,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Cama",R.drawable.cama,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Casa",R.drawable.casa,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Cocina",R.drawable.cocina,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Cristal",R.drawable.cristal,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Despertador",R.drawable.despertador,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Dormitorio",R.drawable.dormitorio,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Lámpara",R.drawable.lampara,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Maceta",R.drawable.maceta,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Manta",R.drawable.manta,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Máquina",R.drawable.maquina,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Mesilla",R.drawable.mesilla,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Mueble",R.drawable.mueble,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Muñeco",R.drawable.muneco,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Objeto",R.drawable.objeto,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Pelota",R.drawable.pelota,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Plancha",R.drawable.plancha,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Puerta",R.drawable.puerta,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Sábana",R.drawable.sabana,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Salón",R.drawable.salon,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Silla",R.drawable.silla,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Sofá",R.drawable.sofa,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Teléfono",R.drawable.telefono,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Televisor",R.drawable.televisor,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Ventana",R.drawable.ventana,"Casa","Casa"));
        realm.copyToRealmOrUpdate(new Palabra("Video",R.drawable.video,"Casa","Casa"));

        realm.copyToRealmOrUpdate(new Palabra("Cacerola",R.drawable.cacerola,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Cocina",R.drawable.cocina,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Cuchara",R.drawable.cuchara,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Cuchillo",R.drawable.cuchillo,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Jarra",R.drawable.jarra,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Lavadora",R.drawable.lavadora,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Nevera",R.drawable.nevera,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Objetos",R.drawable.objetos,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Plato",R.drawable.plato,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Sartén",R.drawable.sarten,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Servilleta",R.drawable.servilleta,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Tenedor",R.drawable.tenedor,"Casa","ObjetosDeCocina"));
        realm.copyToRealmOrUpdate(new Palabra("Vaso",R.drawable.vaso,"Casa","ObjetosDeCocina"));

        realm.copyToRealmOrUpdate(new Palabra("Baño",R.drawable.bano,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Bañera",R.drawable.banera,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Cepillo",R.drawable.cepillo,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Champú",R.drawable.champu,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Colonia",R.drawable.colonia,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Espejo",R.drawable.espejo,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Esponja",R.drawable.esponja,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Jabón",R.drawable.jabon,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Lavabo",R.drawable.lavabo,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Objetos",R.drawable.objetos,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Papel",R.drawable.papel,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Pasta de dientes",R.drawable.pasta_de_dientes,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Peine",R.drawable.peine,"Casa","ObjetosDeBaño"));
        realm.copyToRealmOrUpdate(new Palabra("Toalla",R.drawable.toalla,"Casa","ObjetosDeBaño"));

        realm.copyToRealmOrUpdate(new Palabra("Acera",R.drawable.acera,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Banco (Dinero)",R.drawable.banco_dinero,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Banco (Sentarse)",R.drawable.banco_sentar,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Biblioteca",R.drawable.biblioteca,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Buzón",R.drawable.buzon,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Calle",R.drawable.calle,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Cine",R.drawable.cine,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Ciudad",R.drawable.ciudad,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Colegio",R.drawable.colegio,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Columpio",R.drawable.columpio,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Farola",R.drawable.farola,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Fuente",R.drawable.fuente,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Hospital",R.drawable.hospital,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Librería",R.drawable.libreria,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Luz",R.drawable.luz,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Museo",R.drawable.museo,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Parque",R.drawable.parque,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Paso de cebra",R.drawable.paso_de_cebra,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Pastelería",R.drawable.pasteleria,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Plaza",R.drawable.plaza,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Puente",R.drawable.puente,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Quiosco",R.drawable.quiosco,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Semáforo",R.drawable.semaforo,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Supermercado",R.drawable.supermercado,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Teatro",R.drawable.teatro,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Tienda",R.drawable.tienda,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Tobogán",R.drawable.tobogan,"Ciudad","Ciudad"));
        realm.copyToRealmOrUpdate(new Palabra("Zapatería",R.drawable.zapateria,"Ciudad","Ciudad"));

        realm.copyToRealmOrUpdate(new Palabra("Ambulancia",R.drawable.ambulancia,"Ciudad","MediosDeTransporte"));
        realm.copyToRealmOrUpdate(new Palabra("Autobús",R.drawable.autobus,"Ciudad","MediosDeTransporte"));
        realm.copyToRealmOrUpdate(new Palabra("Barca",R.drawable.barca,"Ciudad","MediosDeTransporte"));
        realm.copyToRealmOrUpdate(new Palabra("Bicicleta",R.drawable.bicicleta,"Ciudad","MediosDeTransporte"));
        realm.copyToRealmOrUpdate(new Palabra("Camión",R.drawable.camion,"Ciudad","MediosDeTransporte"));
        realm.copyToRealmOrUpdate(new Palabra("Coche",R.drawable.coche,"Ciudad","MediosDeTransporte"));
        realm.copyToRealmOrUpdate(new Palabra("Moto",R.drawable.moto,"Ciudad","MediosDeTransporte"));
        realm.copyToRealmOrUpdate(new Palabra("Vehículo",R.drawable.vehiculo,"Ciudad","MediosDeTransporte"));

        realm.copyToRealmOrUpdate(new Palabra("Bombero",R.drawable.bombero,"Ciudad","Profesiones"));
        realm.copyToRealmOrUpdate(new Palabra("Médico",R.drawable.medico,"Ciudad","Profesiones"));
        realm.copyToRealmOrUpdate(new Palabra("Pastelero",R.drawable.pastelero,"Ciudad","Profesiones"));
        realm.copyToRealmOrUpdate(new Palabra("Pescador",R.drawable.pescador,"Ciudad","Profesiones"));
        realm.copyToRealmOrUpdate(new Palabra("Policía",R.drawable.policia,"Ciudad","Profesiones"));
        realm.copyToRealmOrUpdate(new Palabra("Profesiones",R.drawable.profesiones,"Ciudad","Profesiones"));
        realm.copyToRealmOrUpdate(new Palabra("Profesor",R.drawable.profesor,"Ciudad","Profesiones"));
        realm.copyToRealmOrUpdate(new Palabra("Transporte",R.drawable.transporte,"Ciudad","Profesiones"));

        realm.copyToRealmOrUpdate(new Palabra("Abecedario",R.drawable.abecedario,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Alumno",R.drawable.alumno,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Clase",R.drawable.clase,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Colegio",R.drawable.colegio,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Dibujo",R.drawable.dibujo,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Diferencia",R.drawable.diferencia,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Gramo",R.drawable.gramo,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Lenguaje De Signos español",R.drawable.lenguajessignosespa_ola,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Litro",R.drawable.litro,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Medida",R.drawable.medida,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Metro",R.drawable.metro,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Multiplicación",R.drawable.multiplicacion,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Número",R.drawable.numero,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Palabra",R.drawable.palabra,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Patio",R.drawable.patio,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Resta",R.drawable.resta,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Servicio",R.drawable.servicio,"Colegio","Colegio"));
        realm.copyToRealmOrUpdate(new Palabra("Suma",R.drawable.suma,"Colegio","Colegio"));

        realm.copyToRealmOrUpdate(new Palabra("Amarillo",R.drawable.amarillo,"Colegio","Colores"));
        realm.copyToRealmOrUpdate(new Palabra("Azul",R.drawable.azul,"Colegio","Colores"));
        realm.copyToRealmOrUpdate(new Palabra("Blanco",R.drawable.blanco,"Colegio","Colores"));
        realm.copyToRealmOrUpdate(new Palabra("Colores",R.drawable.colores,"Colegio","Colores"));
        realm.copyToRealmOrUpdate(new Palabra("Marrón",R.drawable.marron,"Colegio","Colores"));
        realm.copyToRealmOrUpdate(new Palabra("Naranja",R.drawable.naranja,"Colegio","Colores"));
        realm.copyToRealmOrUpdate(new Palabra("Negro",R.drawable.negro,"Colegio","Colores"));
        realm.copyToRealmOrUpdate(new Palabra("Rojo",R.drawable.rojo,"Colegio","Colores"));
        realm.copyToRealmOrUpdate(new Palabra("Rosa",R.drawable.rosa,"Colegio","Colores"));
        realm.copyToRealmOrUpdate(new Palabra("Verde",R.drawable.verde,"Colegio","Colores"));

        realm.copyToRealmOrUpdate(new Palabra("Bolígrafo",R.drawable.boligrafo,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Borrador",R.drawable.borrador,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Cera",R.drawable.cera,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Cosas del colegio",R.drawable.cosas_del_colegio,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Cosas",R.drawable.cosas,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Cuaderno",R.drawable.cuaderno,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Cuento",R.drawable.cuento,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Diccionario",R.drawable.diccionario,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Goma",R.drawable.goma,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Hoja",R.drawable.hoja,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Lápices de colores",R.drawable.lapices_de_colores,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Lápiz",R.drawable.lapiz,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Libro",R.drawable.libro,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Papel",R.drawable.papel,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Papelera",R.drawable.papelera,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Pegamento",R.drawable.pegamento,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Pintura",R.drawable.pintura,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Pizarra",R.drawable.pizarra,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Plastilina",R.drawable.plastilina,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Rotulador",R.drawable.rotulador,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Sacapuntas",R.drawable.sacapuntas,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Tijeras",R.drawable.tijeras,"Colegio","CosasDelColegio"));
        realm.copyToRealmOrUpdate(new Palabra("Tiza",R.drawable.tiza,"Colegio","CosasDelColegio"));

        realm.copyToRealmOrUpdate(new Palabra("Círculo",R.drawable.circulo,"Colegio","FormasYTamaños"));
        realm.copyToRealmOrUpdate(new Palabra("Cuadrado",R.drawable.cuadrado,"Colegio","FormasYTamaños"));
        realm.copyToRealmOrUpdate(new Palabra("Formas y Tamaños",R.drawable.formas_y_tamanos,"Colegio","FormasYTamaños"));
        realm.copyToRealmOrUpdate(new Palabra("Formas",R.drawable.formas,"Colegio","FormasYTamaños"));
        realm.copyToRealmOrUpdate(new Palabra("Grande",R.drawable.grande,"Colegio","FormasYTamaños"));
        realm.copyToRealmOrUpdate(new Palabra("Mediano",R.drawable.mediano,"Colegio","FormasYTamaños"));
        realm.copyToRealmOrUpdate(new Palabra("Pequeño",R.drawable.pequeno,"Colegio","FormasYTamaños"));
        realm.copyToRealmOrUpdate(new Palabra("Tamaño",R.drawable.tamano,"Colegio","FormasYTamaños"));

        realm.copyToRealmOrUpdate(new Palabra("Aceite",R.drawable.aceite,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Alimento",R.drawable.alimento,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Arroz",R.drawable.arroz,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Azucar",R.drawable.azucar,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Bebida",R.drawable.bebida,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Bocadillo",R.drawable.bocadillo,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Caramelo",R.drawable.caramelo,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Carnes",R.drawable.carnes,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Cebolla",R.drawable.cebolla,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Cena",R.drawable.cena,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Chocolate",R.drawable.chocolate,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Comida",R.drawable.comida,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Desayuno",R.drawable.desayuno,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Galleta",R.drawable.galleta,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Huevo",R.drawable.huevo,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Leche",R.drawable.leche,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Lechuga",R.drawable.lechuga,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Limón",R.drawable.limon,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Macarrones",R.drawable.macarrones,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Merienda",R.drawable.merienda,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Pan",R.drawable.pan,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Patata",R.drawable.patata,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Pescado",R.drawable.pescado,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Pollo",R.drawable.pollo,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Puré",R.drawable.pure,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Queso",R.drawable.queso,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Sal",R.drawable.sal,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Sed",R.drawable.sed,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Sopa",R.drawable.sopa,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Tomate",R.drawable.tomate,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Zanahoria",R.drawable.zanahoria,"Comidas Y Bebidas","Comidas Y Bebidas"));
        realm.copyToRealmOrUpdate(new Palabra("Zumo",R.drawable.zumo,"Comidas Y Bebidas","Comidas Y Bebidas"));

        realm.copyToRealmOrUpdate(new Palabra("Dulce",R.drawable.dulce,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Flan",R.drawable.flan,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Fresa",R.drawable.fresa,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Fruta",R.drawable.fruta,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Helado",R.drawable.helado,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Manzana",R.drawable.manzana,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Naranja",R.drawable.naranja,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Pera",R.drawable.pera,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Platano",R.drawable.platano,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Postre",R.drawable.postre,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Sandía",R.drawable.sandia,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Tarta",R.drawable.tarta,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Uva",R.drawable.uva,"Comidas Y Bebidas","Postres"));
        realm.copyToRealmOrUpdate(new Palabra("Yogur",R.drawable.yogur,"Comidas Y Bebidas","Postres"));

        realm.copyToRealmOrUpdate(new Palabra("Abuelo",R.drawable.abuelo,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Amigo",R.drawable.amigo,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Bebé",R.drawable.bebe,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Ciego",R.drawable.ciego,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Familia",R.drawable.familia,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Hermano",R.drawable.hermano,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Mamá",R.drawable.mama,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Niña",R.drawable.nina,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Niño",R.drawable.nino,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Papá",R.drawable.papa,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Persona",R.drawable.persona,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Primo",R.drawable.primo,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Sordo",R.drawable.sordo,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Sordo ciego",R.drawable.sordociego,"Familia","Familia"));
        realm.copyToRealmOrUpdate(new Palabra("Tío",R.drawable.tio,"Familia","Familia"));

        realm.copyToRealmOrUpdate(new Palabra("Abeja",R.drawable.abeja,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Águila",R.drawable.aguila,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Animal",R.drawable.animal,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Ballena",R.drawable.ballena,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Burro",R.drawable.burro,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Caballo",R.drawable.caballo,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Cabra",R.drawable.cabra,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Camello",R.drawable.camello,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Cerdo",R.drawable.cerdo,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Cocodrilo",R.drawable.cocodrilo,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Conejo",R.drawable.conejo,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Delfín",R.drawable.delfin,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Elefante",R.drawable.elefante,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Foca",R.drawable.foca,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Gallina",R.drawable.gallina,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Gato",R.drawable.gato,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Granja",R.drawable.granja,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Jirafa",R.drawable.jirafa,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("León",R.drawable.leon,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Loro",R.drawable.loro,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Mariposa",R.drawable.mariposa,"Naturaleza","Animales"));
        realm.copyToRealmOrUpdate(new Palabra("Mono",R.drawable.mono,"Naturaleza","Animales"));

        realm.copyToRealmOrUpdate(new Palabra("Abeto",R.drawable.abeto,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Árbol",R.drawable.arbol,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Arcoíris",R.drawable.arco_iris,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Arena",R.drawable.arena,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Estrella",R.drawable.estrella,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Faro",R.drawable.faro,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Flor",R.drawable.flor,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Flotador",R.drawable.flotador,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Fuego",R.drawable.fuego,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Hierba",R.drawable.hierba,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Hoja",R.drawable.hoja,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Lago",R.drawable.lago,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Luna",R.drawable.luna,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Mar",R.drawable.mar,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Margarita",R.drawable.margarita,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Montaña",R.drawable.montana,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Naturaleza",R.drawable.naturaleza,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Palmera",R.drawable.palmera,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Piedra",R.drawable.piedra,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Playa",R.drawable.playa,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Pozo",R.drawable.pozo,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Río",R.drawable.rio,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Saco de dormir",R.drawable.saco_de_dormir,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Sombrilla",R.drawable.sombrilla,"Naturaleza","Naturaleza"));
        realm.copyToRealmOrUpdate(new Palabra("Tienda de campaña",R.drawable.tienda_campana,"Naturaleza","Naturaleza"));

        realm.copyToRealmOrUpdate(new Palabra("Calor",R.drawable.calor,"Naturaleza","TiempoAtmosferico"));
        realm.copyToRealmOrUpdate(new Palabra("Frío",R.drawable.frio,"Naturaleza","TiempoAtmosferico"));
        realm.copyToRealmOrUpdate(new Palabra("Lluvia",R.drawable.lluvia,"Naturaleza","TiempoAtmosferico"));
        realm.copyToRealmOrUpdate(new Palabra("Nieve",R.drawable.nieve,"Naturaleza","TiempoAtmosferico"));
        realm.copyToRealmOrUpdate(new Palabra("Nube",R.drawable.nube,"Naturaleza","TiempoAtmosferico"));
        realm.copyToRealmOrUpdate(new Palabra("Nublado",R.drawable.nublado,"Naturaleza","TiempoAtmosferico"));
        realm.copyToRealmOrUpdate(new Palabra("Sol",R.drawable.sol,"Naturaleza","TiempoAtmosferico"));
        realm.copyToRealmOrUpdate(new Palabra("Tiempo atmosfético",R.drawable.tiempo_atmosferico,"Naturaleza","TiempoAtmosferico"));
        realm.copyToRealmOrUpdate(new Palabra("Tormenta",R.drawable.tormenta,"Naturaleza","TiempoAtmosferico"));
        realm.copyToRealmOrUpdate(new Palabra("Viento",R.drawable.viento,"Naturaleza","TiempoAtmosferico"));

        realm.copyToRealmOrUpdate(new Palabra("Día de la semana",R.drawable.dia_de_la_semana,"Calendario","Semana"));
        realm.copyToRealmOrUpdate(new Palabra("Día",R.drawable.dia_manana,"Calendario","Semana"));
        realm.copyToRealmOrUpdate(new Palabra("Domingo",R.drawable.domingo,"Calendario","Semana"));
        realm.copyToRealmOrUpdate(new Palabra("Fin de semana",R.drawable.fin_de_semana,"Calendario","Semana"));
        realm.copyToRealmOrUpdate(new Palabra("Jueves",R.drawable.jueves,"Calendario","Semana"));
        realm.copyToRealmOrUpdate(new Palabra("Lunes",R.drawable.lunes,"Calendario","Semana"));
        realm.copyToRealmOrUpdate(new Palabra("Martes",R.drawable.martes,"Calendario","Semana"));
        realm.copyToRealmOrUpdate(new Palabra("Miercoles",R.drawable.miercoles,"Calendario","Semana"));
        realm.copyToRealmOrUpdate(new Palabra("Sabado",R.drawable.sabado,"Calendario","Semana"));
        realm.copyToRealmOrUpdate(new Palabra("Semana",R.drawable.semana,"Calendario","Semana"));
        realm.copyToRealmOrUpdate(new Palabra("Viernes",R.drawable.viernes,"Calendario","Semana"));

        realm.copyToRealmOrUpdate(new Palabra("Estaciones",R.drawable.estaciones,"Calendario","Estaciones"));
        realm.copyToRealmOrUpdate(new Palabra("Invierno",R.drawable.invierno,"Calendario","Estaciones"));
        realm.copyToRealmOrUpdate(new Palabra("Otoño",R.drawable.otono,"Calendario","Estaciones"));
        realm.copyToRealmOrUpdate(new Palabra("Primavera",R.drawable.primavera,"Calendario","Estaciones"));
        realm.copyToRealmOrUpdate(new Palabra("Verano",R.drawable.verano,"Calendario","Estaciones"));

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

        realm.copyToRealmOrUpdate(new Palabra("Sentidos",R.drawable.sentidos,"Cuerpo","Sentido"));
        realm.copyToRealmOrUpdate(new Palabra("Gusto",R.drawable.gusto,"Cuerpo","Sentido"));
        realm.copyToRealmOrUpdate(new Palabra("Oido",R.drawable.oido,"Cuerpo","Sentido"));
        realm.copyToRealmOrUpdate(new Palabra("Olfato",R.drawable.olfato,"Cuerpo","Sentido"));
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