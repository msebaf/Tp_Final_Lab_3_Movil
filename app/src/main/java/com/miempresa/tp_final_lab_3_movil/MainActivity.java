package com.miempresa.tp_final_lab_3_movil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.miempresa.tp_final_lab_3_movil.databinding.ActivityMainBinding;
import com.miempresa.tp_final_lab_3_movil.modelo.Propietario;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Inmobiliaria");

        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        mv.getUsuarioActual().observe(this, new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                Intent intent = new Intent(getApplication().getApplicationContext(), MenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


                getApplication().getApplicationContext().startActivity(intent);
            }
        });

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mv.login(binding.etUsuario.getText().toString(),binding.etPass.getText().toString());
            }
        });
    }
}