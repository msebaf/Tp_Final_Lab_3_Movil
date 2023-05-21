package com.miempresa.tp_final_lab_3_movil.ui.slideshow;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;
import com.miempresa.tp_final_lab_3_movil.modelo.Propietario;
import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

import java.util.ArrayList;

public class SlideshowViewModel extends AndroidViewModel {



    private ApiClient ac;

    public SlideshowViewModel(@NonNull Application application) {
        super(application);

    }




    public ArrayList<Inmueble> consultarInmuebles() {
        ac= ApiClient.getApi();
        return ac.obtnerPropiedades();
    }
}