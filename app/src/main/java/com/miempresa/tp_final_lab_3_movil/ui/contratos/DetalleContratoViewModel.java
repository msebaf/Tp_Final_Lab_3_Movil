package com.miempresa.tp_final_lab_3_movil.ui.contratos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.miempresa.tp_final_lab_3_movil.modelo.Contrato;
import com.miempresa.tp_final_lab_3_movil.modelo.Inmueble;
import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

public class DetalleContratoViewModel extends AndroidViewModel {

    private MutableLiveData<Contrato> contrato;
    private ApiClient ac;

    public DetalleContratoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }

    public void obtenerContrato(Inmueble inmueble) {
        ac = ApiClient.getApi();
        contrato.setValue(ac.obtenerContratoVigente(inmueble));
    }
}
