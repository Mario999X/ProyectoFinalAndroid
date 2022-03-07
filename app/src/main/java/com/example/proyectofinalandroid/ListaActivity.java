package com.example.proyectofinalandroid;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    public void cargarLista(){
        setOnClickListener();
        ApiService apiService = ApiCliente.getCliente().create(ApiService.class);

        recyclerView = findViewById(R.id.recycler);

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

                adapterProducto = new RecyclerAdapterProducto(productoList, recyclerView.getContext(),clickListener);
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

    private void setOnClickListener() {
        clickListener = new ClickListener() {
            @Override
            public void onItemClick(int posicion, View view) {
                Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
                intent.putExtra("imagen", productoList.get(posicion).getImage());
                intent.putExtra("titulo", productoList.get(posicion).getTitle());
                intent.putExtra("precio", productoList.get(posicion).getPrice());
                startActivity(intent);
            }
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
