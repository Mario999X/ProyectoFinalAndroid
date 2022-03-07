package com.example.proyectofinalandroid;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetalleActivity extends AppCompatActivity {

    ImageView imagenProductoDetalle;

    TextView tituloProductoDetalle, precioProductoDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_productos);

        imagenProductoDetalle = findViewById(R.id.imagenProductoDetalle);
        tituloProductoDetalle = findViewById(R.id.tituloProductoDetalle);
        precioProductoDetalle = findViewById(R.id.precioProductoDetalle);

        String imagenString = "Imagen del producto";
        String titulo = "Titulo del producto";
        String precio = "Precio del producto";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            imagenString = extras.getString("imagen");
            titulo = extras.getString("titulo");
            precio = extras.getString("precio");
        }
        Glide.with(getApplicationContext()).load(imagenString).into(imagenProductoDetalle);
        tituloProductoDetalle.setText(titulo);
        precioProductoDetalle.setText("Precio: "+precio + " €");
    }
}
