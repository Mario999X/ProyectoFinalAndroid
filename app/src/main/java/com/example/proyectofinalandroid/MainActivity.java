package com.example.proyectofinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/* IMPORTANTE MIRAR EL MANIFEST EN LO REFERENTE A LAS ACTIVIDADES + BUILD.GRADLE PARA LAS IMPORTACIONES
TALES COMO GLIDE O RETROFIT

LA INTERNACIONALIZACION SE ENCUENTRA DENTRO DE LA CARPETA VALUES, PRIMERO SOLO HABRA UN ARCHIVO
strings.xml, QUE ES EL PREDETERMINADO, PARA CREAR UN SEGUNDO, SERA NECESARIO PULSAR SOBRE VALUES CON
CLICK DERECHO Y GENERAR UN NUEVO VALUES RESOURCE FILE, CON LA OPCION LOCALE. LUEGO DE ESTO,
SE GENERA AUTOMATICAMENTE UNA CARPETA strings CON LOS ARCHIVOS DENTRO.
 */

// CLASE LOGIN
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

    /* Metodo que localiza ambos EditText y se asegura de que haya algo escrito en ellos. Si ese
    es el caso, lanza una nueva actividad.
    En caso negativo, salta un Toast con un mensaje.
     */
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