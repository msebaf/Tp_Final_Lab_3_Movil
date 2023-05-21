package com.miempresa.tp_final_lab_3_movil.ui.Inquilinos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;
import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

import java.util.ArrayList;

public class PropiedadesAlquiladasViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private ApiClient ac;



    public PropiedadesAlquiladasViewModel(@NonNull Application application) {
        super(application);
    }


    public ArrayList<Inmueble> consultarInmuebles() {
        ac = ApiClient.getApi();
        ArrayList<Inmueble> inmuebles = ac.obtenerPropiedadesAlquiladas();

        return inmuebles;
    }

}