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

// CLASE ADAPTER RECYCLERVIEW
public class RecyclerAdapterProducto extends RecyclerView.Adapter<RecyclerAdapterProducto.ViewHolder> {

    List<Producto> productoList;
    Context context;
    private static ClickListener clickListener;

    // Constructor
    public RecyclerAdapterProducto(List<Producto> productoList, Context context, ClickListener clickListener) {
        this.productoList = productoList;
        this.context = context;
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_producto, parent, false);
        return new ViewHolder(view);
    }

    // Rellenamos los campos que tengamos en la vista "vista_productos".
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Producto item = productoList.get(position);

        holder.tituloProducto.setText(item.getTitle());
        holder.precioProducto.setText(context.getString(R.string.app_precio_txt) + " " + item.getPrice() + " €");
        holder.categoriaProducto.setText(context.getString(R.string.app_categoria_txt) + " " + item.getCategory());

        Glide.with(context).load(item.getImage()).into(holder.imagenProducto);
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    // CLASE VIEWHOLDER, IMPLEMENTANDO ONCLICKLISTENER
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tituloProducto, precioProducto, categoriaProducto;
        ImageView imagenProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tituloProducto = itemView.findViewById(R.id.textView_title);
            precioProducto = itemView.findViewById(R.id.textView_price);
            categoriaProducto = itemView.findViewById(R.id.textView_category);
            imagenProducto = itemView.findViewById(R.id.imageView_product);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition());
        }
    }
}
