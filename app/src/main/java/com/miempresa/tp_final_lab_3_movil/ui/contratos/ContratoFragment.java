package com.miempresa.tp_final_lab_3_movil.ui.contratos;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miempresa.tp_final_lab_3_movil.R;
import com.miempresa.tp_final_lab_3_movil.databinding.FragmentContratoBinding;
import com.miempresa.tp_final_lab_3_movil.databinding.FragmentPropiedadesAlquiladasBinding;
import com.miempresa.tp_final_lab_3_movil.ui.Inquilinos.PropiedadesAlquiladasFragmentAdapter;
import com.miempresa.tp_final_lab_3_movil.ui.Inquilinos.PropiedadesAlquiladasViewModel;

public class ContratoFragment extends Fragment {

    private ContratoViewModel vm;
    private FragmentContratoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PropiedadesAlquiladasViewModel propiedadesAlquiladasViewModel =
                new ViewModelProvider(this).get(PropiedadesAlquiladasViewModel.class);

        binding = FragmentContratoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vm = new ViewModelProvider(this).get(ContratoViewModel.class);

        RecyclerView rv = binding.rvInmuebles;

        GridLayoutManager grilla = new GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(grilla);
        ContratosFragmentAdapter adapter = new ContratosFragmentAdapter(requireContext(), vm.consultarInmuebles(), getLayoutInflater());
        rv.setAdapter(adapter);



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}