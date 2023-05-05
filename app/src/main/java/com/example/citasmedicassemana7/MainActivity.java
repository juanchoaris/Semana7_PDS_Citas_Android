package com.example.citasmedicassemana7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegistrar = findViewById(R.id.BtnRegistrar);
        Button btnConsultar = findViewById(R.id.BtnConsultar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten_register = new Intent(MainActivity.this, Register.class);

                Database_administrator database_administrator = new Database_administrator();
                boolean confirm = database_administrator.connectSQL();

                if (confirm){
                    startActivity(inten_register);
                }
                else{
                    Toast.makeText(MainActivity.this, "No hay conexión con el Servidor", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten_consul = new Intent(MainActivity.this, Consult.class);
                startActivity(inten_consul);
            }
        });
    }
}