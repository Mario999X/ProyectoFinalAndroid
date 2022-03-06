package com.example.proyectofinalandroid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;;

public class ListaActivity extends AppCompatActivity {

    List<Producto> productoList = new ArrayList<>();
    RecyclerAdapterProducto adapterProducto;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        cargarLista();

    }

    private void cargarLista(){
        ApiService apiService = ApiCliente.getCliente().create(ApiService.class);

        RecyclerView recyclerView = findViewById(R.id.recycler);

        layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        Call<List<Producto>> listCall = apiService.getAllProducto();

        listCall.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(recyclerView.getContext(),"Error en la conexion", Toast.LENGTH_SHORT).show();
                }
                //cargar la lista de elemento en la lista
                productoList = response.body();

                adapterProducto = new RecyclerAdapterProducto(productoList, recyclerView.getContext());
                recyclerView.setAdapter(adapterProducto);
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

                //ha fallado la conexion
                Toast.makeText(recyclerView.getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("info", "onFailure: "+t.getMessage());
            }
        });
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
