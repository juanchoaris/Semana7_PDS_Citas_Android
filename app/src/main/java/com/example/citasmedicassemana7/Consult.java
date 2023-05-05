package com.example.citasmedicassemana7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Consult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        Button btnRegresar = findViewById(R.id.BtnRegresar);
        ListView list = findViewById(R.id.LstViewCitas);
        Database_administrator database_administrator = new Database_administrator();
        database_administrator.connectSQL();

        ArrayList<String> lista = database_administrator.selectRecord();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        list.setAdapter(arrayAdapter);


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten_consul = new Intent(Consult.this, MainActivity.class);
                startActivity(inten_consul);
            }
        });
    }
}