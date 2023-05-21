package com.miempresa.tp_final_lab_3_movil.ui.Inquilinos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.miempresa.tp_final_lab_3_movil.R;
import com.miempresa.tp_final_lab_3_movil.databinding.ActivityDetalleBinding;
import com.miempresa.tp_final_lab_3_movil.databinding.ActivityDetalleInquilinoBinding;
import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;
import com.miempresa.tp_final_lab_3_movil.modelo.Inquilino;

public class DetalleInquilinoActivity extends AppCompatActivity {

    private ActivityDetalleInquilinoBinding binding;

    private Inquilino inquilino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detalle_inquilino);
        binding = ActivityDetalleInquilinoBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        inquilino = (Inquilino) getIntent().getSerializableExtra("inquilino");

        binding.etCodigo.setText(String.valueOf(inquilino.getIdInquilino()));
        binding.etApellido.setText(String.valueOf(inquilino.getApellido()));
        binding.etDni.setText(String.valueOf(inquilino.getDNI()));
        binding.etNombre.setText(String.valueOf(inquilino.getNombre()));
        binding.etEmail.setText(String.valueOf(inquilino.getEmail()));
        binding.etTelefono.setText(String.valueOf(inquilino.getTelefono()));
        binding.etGarante.setText(String.valueOf(inquilino.getNombreGarante()));
        binding.etTelefonoGarante.setText(String.valueOf(inquilino.getTelefonoGarante()));
    }
}