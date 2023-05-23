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

    public String seleccionarTitulo(int id) {
        String title;
        switch (id) {
            case R.id.nav_home:
                title = "Mapa de la inmobiliaria";
                break;
            case R.id.nav_gallery:
                title = "Perfil";
                break;
            case R.id.nav_slideshow:
                title = "Tus Inmuebles";
                break;
            case R.id.nav_deyalleInmuebleFragment:
                title = "Datos del inmueble";
                break;
            case R.id.nav_propiedadesAlquiladas:
                title = "Tus alquileres";
                break;
            case R.id.nav_detalle_inqui:
                title = "Inquilino";
                break;
            case R.id.nav_contratos:
                title = "Contratos";
                break;
            case R.id.nav_detalleContratoFragment:
                title = "Detalle del contrato";
                break;
            case R.id.nav_pagosFragment:
                title = "Pagos Recibidos";
                break;
            default:
                title = "Salir";
                break;
        }
        return title;
    }
}
