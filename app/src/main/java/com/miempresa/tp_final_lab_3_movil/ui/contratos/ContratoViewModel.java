package com.miempresa.tp_final_lab_3_movil.ui.contratos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;
import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

import java.util.ArrayList;

public class ContratoViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private ApiClient ac;



    public ContratoViewModel(@NonNull Application application) {
        super(application);
    }


    public ArrayList<Inmueble> consultarInmuebles() {
        ac = ApiClient.getApi();
        ArrayList<Inmueble> inmuebles = ac.obtenerPropiedadesAlquiladas();

        return inmuebles;
    }

}