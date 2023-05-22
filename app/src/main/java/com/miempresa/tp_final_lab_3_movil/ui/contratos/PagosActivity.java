package com.miempresa.tp_final_lab_3_movil.ui.contratos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.miempresa.tp_final_lab_3_movil.R;
import com.miempresa.tp_final_lab_3_movil.databinding.ActivityPagosBinding;
import com.miempresa.tp_final_lab_3_movil.modelo.Contrato;
import com.miempresa.tp_final_lab_3_movil.modelo.Pago;

import java.util.ArrayList;

public class PagosActivity extends AppCompatActivity {

    private PagosActivityViewModel vm;

    private ActivityPagosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);

        RecyclerView rv = findViewById(R.id.rvPagos);
        Contrato contrato = (Contrato) getIntent().getSerializableExtra("contrato");

        vm = new ViewModelProvider(this).get(PagosActivityViewModel.class);

        vm.getPagos().observe(this, new Observer<ArrayList<Pago>>() {
            @Override
            public void onChanged(ArrayList<Pago> pagos) {
                PagsActivityAdapter adapter = new PagsActivityAdapter(PagosActivity.this, pagos, getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });

        vm.obtenerPagos(contrato);

        GridLayoutManager grilla = new GridLayoutManager(PagosActivity.this, 1, GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(grilla);

    }
}