package com.example.proyectofinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipalActivity extends AppCompatActivity {

    TextView txtUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        cargarNombreUser();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void cargarNombreUser(){
        txtUsuario = findViewById(R.id.txtUsuario);

        String nombreUsuario = "Nombre del usuario";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            nombreUsuario = extras.getString("nombreUsuario");
        }
        txtUsuario.setText(nombreUsuario);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    public void verLista(View view){
        Intent intent = new Intent(MenuPrincipalActivity.this, ListaActivity.class);
        startActivity(intent);
    }

    public void verTabla(View view){
        Intent intent = new Intent(MenuPrincipalActivity.this, TablaActivity.class);
        startActivity(intent);
    }

}
