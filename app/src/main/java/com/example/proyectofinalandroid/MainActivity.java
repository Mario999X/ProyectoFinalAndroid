package com.example.proyectofinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText campoUsuario, campoContraseñaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void verMenuPrincipal(View view) {
        campoUsuario = findViewById(R.id.campoUsuario);
        campoContraseñaUsuario = findViewById(R.id.campoContraseñaUsuario);

        if (campoUsuario.getText().toString().trim().length() > 0 && campoContraseñaUsuario.getText().toString().trim().length() > 0) {
            Intent intent = new Intent(MainActivity.this, MenuPrincipalActivity.class);
            startActivity(intent);
            campoUsuario.setText("");
            campoContraseñaUsuario.setText("");

        } else {
            Toast.makeText(this, R.string.app_aviso_login, Toast.LENGTH_SHORT).show();
        }
    }
}