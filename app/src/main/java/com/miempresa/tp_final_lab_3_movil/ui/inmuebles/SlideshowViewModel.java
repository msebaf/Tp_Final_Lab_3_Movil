package com.miempresa.tp_final_lab_3_movil.ui.inmuebles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;
import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

import java.util.ArrayList;

public class SlideshowViewModel extends AndroidViewModel {


    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private ApiClient ac;

    public SlideshowViewModel(@NonNull Application application) {
        super(application);

    }


    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            this.inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void consultarInmuebles() {
        ac= ApiClient.getApi();
        inmuebles.setValue(ac.obtnerPropiedades());
    }
}