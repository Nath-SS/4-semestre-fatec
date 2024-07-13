package com.example.aula2003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class Combo extends AppCompatActivity {

    private Spinner cmbNomes;

    private AutoCompleteTextView actNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        cmbNomes = (Spinner) findViewById(R.id.cmbNomes);
        actNome = findViewById(R.id.actNome);

        /* ---------------------------Auto Completar----------------------- */
        String[] auto = {"Amanda", "Carlos", "Gabriel", "Teresa"};
        ArrayAdapter<String> adaptadorAuto = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, auto);

        actNome.setAdapter(adaptadorAuto);
        actNome.setThreshold(1);


        /* ---------------------------Combo----------------------- */
        String[] nomes = {"Fatec Itaquera", "Fatec Guarulhos", "Fatec Barueri"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, nomes);

        cmbNomes.setAdapter(adaptador);

        cmbNomes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nome = String.valueOf(parent.getAdapter().getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
    }
}