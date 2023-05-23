package com.miempresa.tp_final_lab_3_movil.ui.Inquilinos;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miempresa.tp_final_lab_3_movil.R;

import com.miempresa.tp_final_lab_3_movil.databinding.FragmentDetalleInquilinoBinding;
import com.miempresa.tp_final_lab_3_movil.databinding.FragmentPropiedadesAlquiladasBinding;
import com.miempresa.tp_final_lab_3_movil.modelo.Inquilino;

public class DetalleInquilinoFragment extends Fragment {

    private DetalleInquilinoViewModel vm;
    private FragmentDetalleInquilinoBinding binding;

    public static DetalleInquilinoFragment newInstance() {
        return new DetalleInquilinoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        binding = FragmentDetalleInquilinoBinding.inflate(inflater, container, false);

        View root = binding.getRoot();


        Bundle bundle = getArguments();
        Inquilino inquilino = (Inquilino) bundle.getSerializable("inquilino");

        binding.etCodigo.setText(String.valueOf(inquilino.getIdInquilino()));
        binding.etApellido.setText(String.valueOf(inquilino.getApellido()));
        binding.etDni.setText(String.valueOf(inquilino.getDNI()));
        binding.etNombre.setText(String.valueOf(inquilino.getNombre()));
        binding.etEmail.setText(String.valueOf(inquilino.getEmail()));
        binding.etTelefono.setText(String.valueOf(inquilino.getTelefono()));
        binding.etGarante.setText(String.valueOf(inquilino.getNombreGarante()));
        binding.etTelefonoGarante.setText(String.valueOf(inquilino.getTelefonoGarante()));

        return root;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = new ViewModelProvider(this).get(DetalleInquilinoViewModel.class);
        // TODO: Use the ViewModel
    }

}