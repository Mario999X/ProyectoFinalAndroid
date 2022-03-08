package com.example.proyectofinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

// CLASE MENU PRINCIPAL
public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    // Metodo enlazado a "btnProductos". Se encarga de lanzar una nueva actividad.
    public void verLista(View view) {
        Intent intent = new Intent(MenuPrincipalActivity.this, ListaActivity.class);
        startActivity(intent);
    }

    // Metodo enlazado a "btnTabla". Se encarga de lanzar una nueva actividad.
    public void verTabla(View view) {
        Intent intent = new Intent(MenuPrincipalActivity.this, TablaActivity.class);
        startActivity(intent);
    }

}
