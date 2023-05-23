package com.miempresa.tp_final_lab_3_movil.ui.inmuebles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;
import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

import java.util.ArrayList;

public class DeyalleInmuebleViewModel extends ViewModel {
    private ApiClient ac;

    private MutableLiveData<ArrayList<String>> estadoInm;


    public LiveData<ArrayList<String>> getEstadoInm() {
        if (estadoInm == null) {
            this.estadoInm = new MutableLiveData<>();
        }
        return estadoInm;
    }
    public void esatdoInmueble(Inmueble inmueble) {
        ArrayList<String> bt = new ArrayList<>();
        if(inmueble.isEstado()){
            bt.add("Disponible");
            bt.add("#00FF00");
        }else{
            bt.add("No Disponible");
            bt.add("#FF0000");
        }
       estadoInm.setValue(bt);
    }

    public void cambiarEstado(Inmueble inmueble) {
        ac = ApiClient.getApi();
        inmueble.setEstado(!inmueble.isEstado());
        ac.actualizarInmueble(inmueble);

    }
    // TODO: Implement the ViewModel
}