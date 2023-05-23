package com.miempresa.tp_final_lab_3_movil;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.miempresa.tp_final_lab_3_movil.modelo.Propietario;
import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

public class MenuActivityViewModel extends AndroidViewModel {
    private ApiClient ac = ApiClient.getApi();
    private MutableLiveData<Propietario> propietarioLive;
    public MenuActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Propietario> getUsuarioActual() {
        if(propietarioLive==null){
            propietarioLive=new MutableLiveData<>();
        }
        return propietarioLive;
    }

    public void buscarPropietario(){
        propietarioLive.setValue( ac.obtenerUsuarioActual());
    }
}
