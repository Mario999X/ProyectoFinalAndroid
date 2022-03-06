package com.example.proyectofinalandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapterProducto extends RecyclerView.Adapter<RecyclerAdapterProducto.ViewHolder> {

    List<Producto> productoList;
    Context context;

    public RecyclerAdapterProducto(List<Producto> productoList, Context context){
        this.productoList = productoList;
        this.context = context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_producto,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Producto item = productoList.get(position);

        holder.tituloProducto.setText(item.getTitle());
        holder.precioProducto.setText(item.getPrice());
        holder.categoriaProducto.setText(item.getCategory());
        holder.descripcionProducto.setText(item.getDescription());

        Glide.with(context).load(item.getImage()).into(holder.imagenProducto);
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tituloProducto, precioProducto, categoriaProducto, descripcionProducto;
        ImageView imagenProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tituloProducto = itemView.findViewById(R.id.textView_title);
            precioProducto = itemView.findViewById(R.id.textView_price);
            categoriaProducto = itemView.findViewById(R.id.textView_category);
            descripcionProducto = itemView.findViewById(R.id.textView_descripcion);
            imagenProducto = itemView.findViewById(R.id.imageView_product);
        }
    }

}
