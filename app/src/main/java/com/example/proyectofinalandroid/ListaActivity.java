package com.example.proyectofinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// CLASE ACTIVIDAD DE LISTA
public class ListaActivity extends AppCompatActivity {

    List<Producto> productoList = new ArrayList<>();
    RecyclerAdapterProducto adapterProducto;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    ClickListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        cargarLista();
    }

    // Metodo que realiza una llamada usando Retrofit a una API y rellena una lista, luego visible en el RecyclerView
    public void cargarLista() {

        setOnClickListener();
        ApiService apiService = ApiCliente.getCliente().create(ApiService.class);

        recyclerView = findViewById(R.id.recycler);

        layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        Call<List<Producto>> listCall = apiService.getAllProducto();

        listCall.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(@NonNull Call<List<Producto>> call, @NonNull Response<List<Producto>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(recyclerView.getContext(), "Error en la conexion", Toast.LENGTH_SHORT).show();
                }
                //cargar la lista de elemento en la lista
                productoList = response.body();

                adapterProducto = new RecyclerAdapterProducto(productoList, recyclerView.getContext(), clickListener);
                recyclerView.setAdapter(adapterProducto);
            }

            @Override
            public void onFailure(@NonNull Call<List<Producto>> call, @NonNull Throwable t) {

                //ha fallado la conexion
                Toast.makeText(recyclerView.getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("info", "onFailure: " + t.getMessage());
            }
        });
    }

    /* Metodo encargado de recoger la información de la posicion de la lista que uno pulse, esta informacion es pasada a otra actividad,
    iniciada al final del metodo.
     */
    private void setOnClickListener() {
        clickListener = (posicion) -> {
            Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
            intent.putExtra("imagen", productoList.get(posicion).getImage());
            intent.putExtra("titulo", productoList.get(posicion).getTitle());
            intent.putExtra("precio", productoList.get(posicion).getPrice());
            intent.putExtra("categoria", productoList.get(posicion).getCategory());
            intent.putExtra("descripcion", productoList.get(posicion).getDescription());
            startActivity(intent);
        };
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
