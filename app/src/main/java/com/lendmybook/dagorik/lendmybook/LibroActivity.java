package com.lendmybook.dagorik.lendmybook;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class LibroActivity extends AppCompatActivity {

    //Inicializando
    private String urlImagen = "ÑO", titulo_libro = "ÑO", descrpcion_libr = "ÑO", author_libro = "ÑO";

    private ImageView portada;
    private TextView title, author, descripcion ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro2);

        //Referenciando con la vista
        portada = (ImageView) findViewById(R.id.portadas);
        title = (TextView) findViewById(R.id.titulos);
        author = (TextView) findViewById(R.id.autors);
        descripcion= (TextView) findViewById(R.id.descripciones);

        LlenarPantallaDatos();

    }

    public void LoadDatosToShared() {
        SharedPreferences preferences = this.getSharedPreferences("DatosJson", Context.MODE_PRIVATE);
        urlImagen = preferences.getString("img_url", "ÑO");
        titulo_libro = preferences.getString("titulo", "ÑO");
        descrpcion_libr = preferences.getString("descripcion", "ÑO");
        author_libro = preferences.getString("autor", "ÑO");


        Log.e("MyLogActivity", urlImagen);

    }


    public void LlenarPantallaDatos(){

        LoadDatosToShared();

        title.setText(titulo_libro);
        descripcion.setText(descrpcion_libr);
        author.setText(author_libro);

        Glide.with(this).load(urlImagen).into(portada);

    }

}

