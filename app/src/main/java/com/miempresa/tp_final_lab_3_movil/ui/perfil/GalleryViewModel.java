package com.miempresa.tp_final_lab_3_movil.ui.perfil;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.miempresa.tp_final_lab_3_movil.modelo.Propietario;
import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

public class GalleryViewModel extends AndroidViewModel {
    private MutableLiveData<Propietario> propietario;

    private ApiClient ac;
    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Propietario> getPropietario(){;
        if(propietario==null){
            propietario = new MutableLiveData<>();
        }
        return propietario;
    }

    public void traerProp() {
        ac= ApiClient.getApi();
        propietario.setValue(ac.obtenerUsuarioActual());
    }

    public String editarTexto(String nombreBoton) {
        if(nombreBoton.equals("Editar")){
            return "Guardar";
        }else{
            return "Editar";
        }
    }

    public void actualizarPerfil(String boton, String id,String nombre, String apellido, String dni, String contrasenia, String email, String telefono, String avatarF) {
        if (boton.equals("Guardar")) {


            int idI = Integer.parseInt(id);
            Long dniI = Long.parseLong(dni);
            int avatar = Integer.parseInt(avatarF);
            Propietario propietarioB = new Propietario(idI, dniI, nombre, apellido, contrasenia, email, telefono, avatar);
            ac.actualizarPerfil(propietarioB);
        }
    }
}