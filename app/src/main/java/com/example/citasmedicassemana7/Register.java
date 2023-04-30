package com.example.citasmedicassemana7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends AppCompatActivity {
    public static final ArrayList<String> ListaCitas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Spinner spinner = findViewById(R.id.CbxEspecialidad);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Anatomía Patológica");
        arrayList.add("Cardiología Clínica");
        arrayList.add("Cardiología Intervencionista");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        EditText txtNombres = findViewById(R.id.txtNombres);
        EditText txtApellidos = findViewById(R.id.txtApellidos);
        EditText txtDocumento = findViewById(R.id.txtDocumento);
        EditText txtCorreo = findViewById(R.id.txtCorreo);
        EditText txtFecha = findViewById(R.id.txtFecha);
        Button btnGuardar =findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Cita = txtNombres.getText().toString() + " | "  + txtApellidos.getText().toString() + " | "  +
                              txtDocumento.getText().toString() + " | " + txtCorreo.getText().toString() + " | "  +
                              spinner.getSelectedItem().toString() + " | "  + txtFecha.getText().toString();

                ListaCitas.add(Cita);
                Toast.makeText(Register.this, "Registro creado exitosamente!!!", Toast.LENGTH_LONG).show();

                Intent inten_consul= new Intent(Register.this, Consult.class);
                inten_consul.putExtra("ListaCitas", ListaCitas);
                startActivity(inten_consul);
            }
        });
    }
}