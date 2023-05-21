package com.miempresa.tp_final_lab_3_movil.ui.contratos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.miempresa.tp_final_lab_3_movil.R;
import com.miempresa.tp_final_lab_3_movil.databinding.ActivityDetalleContratoBinding;
import com.miempresa.tp_final_lab_3_movil.databinding.ActivityDetalleInquilinoBinding;
import com.miempresa.tp_final_lab_3_movil.modelo.Contrato;
import com.miempresa.tp_final_lab_3_movil.modelo.Inquilino;

public class DetalleContratoActivity extends AppCompatActivity {

    private ActivityDetalleContratoBinding binding;

    private Contrato contrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detalle_inquilino);
        binding = ActivityDetalleContratoBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        contrato = (Contrato) getIntent().getSerializableExtra("contrato");

        binding.etCodigo.setText(String.valueOf(contrato.getIdContrato()));
        binding.etFechaFinalizacion.setText(String.valueOf(contrato.getFechaFin()));
        binding.etFechaInicio.setText(String.valueOf(contrato.getFechaInicio()));
        binding.etInmueble.setText(String.valueOf(contrato.getInmueble().getDireccion()));
        binding.etMonto.setText(String.valueOf(contrato.getMontoAlquiler()));
        binding.etInquilino.setText(contrato.getInquilino().getNombre() + " " + contrato.getInquilino().getApellido());
    }
}