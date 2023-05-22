package com.miempresa.tp_final_lab_3_movil.ui.inmuebles;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.miempresa.tp_final_lab_3_movil.R;
import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;

import java.util.List;

public class SlideshowFragmentAdapter extends RecyclerView.Adapter<SlideshowFragmentAdapter.ViewHolder> {

    private Context context;
    private List<Inmueble> inmuebles;
    private LayoutInflater inf;

    public SlideshowFragmentAdapter(Context context, List<Inmueble> inmuebles, LayoutInflater inf) {
        this.context = context;
        this.inmuebles = inmuebles;
        this.inf = inf;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = inf.inflate(R.layout.inmueble_card ,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //funcionaba igual sin el @SupressLint pero int position estaba e rojo...me sugirio ponerlo...ni idea...


        holder.direccion.setText(inmuebles.get(position).getDireccion()+"");
        holder.precio.setText( "$"+inmuebles.get(position).getPrecio()+"");

        Glide.with(context).
                load(inmuebles.get(position).getImagen()).
                diskCacheStrategy(DiskCacheStrategy.ALL).
               into(holder.foto);
        CardView cv = holder.itemView.findViewById(R.id.cvInm);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("click", "click" + position);
                Intent intent = new Intent(context, DetalleActivity.class);
                inmuebles.get(position).setPropietario(null);
                intent.putExtra("inmueble", inmuebles.get(position));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return inmuebles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView precio, direccion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          foto = itemView.findViewById(R.id.ivFoto);
            precio = itemView.findViewById(R.id.tvPrecio);
            direccion = itemView.findViewById(R.id.tvDireccion);
        }
    }
}
//descomentar cuando tenga fotos