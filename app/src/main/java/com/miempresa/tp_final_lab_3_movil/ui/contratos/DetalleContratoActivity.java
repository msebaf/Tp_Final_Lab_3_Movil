package com.miempresa.tp_final_lab_3_movil.ui.contratos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.miempresa.tp_final_lab_3_movil.R;
import com.miempresa.tp_final_lab_3_movil.databinding.ActivityDetalleContratoBinding;
import com.miempresa.tp_final_lab_3_movil.databinding.ActivityDetalleInquilinoBinding;
import com.miempresa.tp_final_lab_3_movil.modelo.Contrato;
import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;
import com.miempresa.tp_final_lab_3_movil.modelo.Inquilino;
import com.miempresa.tp_final_lab_3_movil.ui.Inquilinos.PropiedadesAlquiladasViewModel;

public class DetalleContratoActivity extends AppCompatActivity {

    private ActivityDetalleContratoBinding binding;
    private DetalleContratoViewModel vm;

    private Inmueble inmueble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detalle_inquilino);
        binding = ActivityDetalleContratoBinding.inflate(getLayoutInflater());
        vm = new ViewModelProvider(this).get(DetalleContratoViewModel.class);
        setContentView(binding.getRoot());

        inmueble = (Inmueble) getIntent().getSerializableExtra("inmueble");

        vm.getContrato().observe(this, new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {
                binding.etCodigo.setText(String.valueOf(contrato.getIdContrato()));
                binding.etFechaFinalizacion.setText(String.valueOf(contrato.getFechaFin()));
                binding.etFechaInicio.setText(String.valueOf(contrato.getFechaInicio()));
                binding.etInmueble.setText(String.valueOf(contrato.getInmueble().getDireccion()));
                binding.etMonto.setText(String.valueOf(contrato.getMontoAlquiler()));
                binding.etInquilino.setText(contrato.getInquilino().getNombre() + " " + contrato.getInquilino().getApellido());

                binding.btPagos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DetalleContratoActivity.this, PagosActivity.class);
                        intent.putExtra("contrato", contrato);

                        startActivity(intent);
                    }
                });
            }
        });

    vm.obtenerContrato(inmueble);


    }
}