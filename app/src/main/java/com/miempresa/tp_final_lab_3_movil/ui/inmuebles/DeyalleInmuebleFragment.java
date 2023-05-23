package com.miempresa.tp_final_lab_3_movil.ui.inmuebles;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.miempresa.tp_final_lab_3_movil.R;
import com.miempresa.tp_final_lab_3_movil.databinding.FragmentDetalleInquilinoBinding;
import com.miempresa.tp_final_lab_3_movil.databinding.FragmentDeyalleInmuebleBinding;
import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;
import com.miempresa.tp_final_lab_3_movil.modelo.Inquilino;

public class DeyalleInmuebleFragment extends Fragment {

    private DeyalleInmuebleViewModel vm;
    private FragmentDeyalleInmuebleBinding binding;

    public static DeyalleInmuebleFragment newInstance() {
        return new DeyalleInmuebleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDeyalleInmuebleBinding.inflate(inflater, container, false);

        View root = binding.getRoot();


        Bundle bundle = getArguments();
        Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");

        binding.etAmbientes.setText(String.valueOf(inmueble.getAmbientes()));
        binding.etCodigo.setText(String.valueOf(inmueble.getIdInmueble()));
        binding.etPrecio.setText(String.valueOf("$"+inmueble.getPrecio()));
        binding.etDireccion.setText(String.valueOf(inmueble.getDireccion()));
        binding.etTipo.setText(String.valueOf(inmueble.getTipo()));
        binding.etUso.setText(String.valueOf(inmueble.getUso()));
        Glide.with(DeyalleInmuebleFragment.this)
                .load(inmueble.getImagen())
                .into(binding.ivFoto);




        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = new ViewModelProvider(this).get(DeyalleInmuebleViewModel.class);
        // TODO: Use the ViewModel
    }

}