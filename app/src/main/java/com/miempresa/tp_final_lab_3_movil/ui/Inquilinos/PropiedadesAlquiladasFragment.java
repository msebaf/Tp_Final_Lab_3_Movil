package com.miempresa.tp_final_lab_3_movil.ui.Inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miempresa.tp_final_lab_3_movil.databinding.FragmentPropiedadesAlquiladasBinding;
import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;

import java.util.ArrayList;

public class PropiedadesAlquiladasFragment extends Fragment {

    private PropiedadesAlquiladasViewModel vm;
    private FragmentPropiedadesAlquiladasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PropiedadesAlquiladasViewModel propiedadesAlquiladasViewModel =
                new ViewModelProvider(this).get(PropiedadesAlquiladasViewModel.class);

        binding = FragmentPropiedadesAlquiladasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vm = new ViewModelProvider(this).get(PropiedadesAlquiladasViewModel.class);

        RecyclerView rv = binding.rvInmuebles;

        vm.getInmuebles().observe(getViewLifecycleOwner(), new Observer<ArrayList<Inmueble>>() {
            @Override
            public void onChanged(ArrayList<Inmueble> inmuebles) {
                PropiedadesAlquiladasFragmentAdapter adapter = new PropiedadesAlquiladasFragmentAdapter(requireContext(), inmuebles, getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });
        vm.consultarInmuebles();

        GridLayoutManager grilla = new GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(grilla);




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}