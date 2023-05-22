package com.miempresa.tp_final_lab_3_movil.ui.inmuebles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.miempresa.tp_final_lab_3_movil.databinding.ActivityDetalleBinding;
import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;

public class DetalleActivity extends AppCompatActivity {
    private ActivityDetalleBinding binding;
    Inmueble inmueble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetalleBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        inmueble = (Inmueble) getIntent().getSerializableExtra("inmueble");

        binding.etAmbientes.setText(String.valueOf(inmueble.getAmbientes()));
        binding.etCodigo.setText(String.valueOf(inmueble.getIdInmueble()));
        binding.etPrecio.setText(String.valueOf("$"+inmueble.getPrecio()));
        binding.etDireccion.setText(String.valueOf(inmueble.getDireccion()));
        binding.etTipo.setText(String.valueOf(inmueble.getTipo()));
        binding.etUso.setText(String.valueOf(inmueble.getUso()));
        Glide.with(DetalleActivity.this)
                .load(inmueble.getImagen())
                .into(binding.ivFoto);


    }
}