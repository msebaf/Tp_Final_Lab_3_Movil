package com.miempresa.tp_final_lab_3_movil.ui.Inquilinos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;
import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

import java.util.ArrayList;

public class PropiedadesAlquiladasViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private ApiClient ac;



    public PropiedadesAlquiladasViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            this.inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }
    public void consultarInmuebles() {
        ac = ApiClient.getApi();
      inmuebles.setValue(ac.obtenerPropiedadesAlquiladas());


    }

}