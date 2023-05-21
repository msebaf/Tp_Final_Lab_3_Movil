package com.miempresa.tp_final_lab_3_movil;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.AndroidViewModel;

import com.miempresa.tp_final_lab_3_movil.request.ApiClient;

import java.io.Serializable;

public class MainActivityViewModel extends AndroidViewModel {
    private ApiClient ac = ApiClient.getApi();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void login(String email, String password) {
        ac.login(email, password);
        if (ac.obtenerUsuarioActual()!=null){
            Intent intent = new Intent(getApplication().getApplicationContext(), MenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            getApplication().getApplicationContext().startActivity(intent);
        }else{
            //implementar mensaje de error
        }

    }
}
