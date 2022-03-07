package com.example.proyectofinalandroid;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetalleActivity extends AppCompatActivity {

    ImageView imagenProductoDetalle;

    TextView tituloProductoDetalle, precioProductoDetalle, descripcionProductoDetalle, categoriaProductoDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_productos);

        imagenProductoDetalle = findViewById(R.id.imagenProductoDetalle);
        tituloProductoDetalle = findViewById(R.id.tituloProductoDetalle);
        precioProductoDetalle = findViewById(R.id.precioProductoDetalle);
        categoriaProductoDetalle = findViewById(R.id.categoriaProductoDetalle);
        descripcionProductoDetalle = findViewById(R.id.descripcionProductoDetalle);

        String imagenString = "Imagen del producto";
        String titulo = "Titulo del producto";
        String precio = "Precio del producto";
        String categoria = "Categoria del producto";
        String descripcion = "Descripcion del producto";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            imagenString = extras.getString("imagen");
            titulo = extras.getString("titulo");
            precio = extras.getString("precio");
            categoria = extras.getString("categoria");
            descripcion = extras.getString("descripcion");
        }
        Glide.with(getApplicationContext()).load(imagenString).into(imagenProductoDetalle);
        tituloProductoDetalle.setText(titulo);
        precioProductoDetalle.setText("Precio: "+precio + " €");
        categoriaProductoDetalle.setText("Categoría: " +categoria);
        descripcionProductoDetalle.setText(descripcion);
    }
}
