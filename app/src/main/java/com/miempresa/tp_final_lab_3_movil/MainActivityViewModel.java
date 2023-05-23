package com.miempresa.tp_final_lab_3_movil;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.miempresa.tp_final_lab_3_movil.modelo.Propietario;
import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

import java.io.Serializable;

public class MainActivityViewModel extends AndroidViewModel {
    private ApiClient ac = ApiClient.getApi();

    private MutableLiveData <Propietario> usuarioActual = new MutableLiveData<>();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Propietario> getUsuarioActual() {
        if(usuarioActual==null){
            usuarioActual=new MutableLiveData<>();
        }
        return usuarioActual;
    }
    public void login(String email, String password) {
       usuarioActual.setValue(ac.login(email, password));

    }


}
