package com.example.atividadepratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCalc, btnCompras, btnRestaurante, btnSalario, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc = findViewById(R.id.btnCalc);
        btnCompras = findViewById(R.id.btnCompras);
        btnRestaurante = findViewById(R.id.btnRestaurante);
        btnSalario = findViewById(R.id.btnSalario);
        btnSair = findViewById(R.id.btnSair);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void Calc(View view){
        Intent it = new Intent(getApplicationContext(), Calculadora.class);
        startActivity(it);
    }

    public void Restaurante(View view){
        Intent it = new Intent(getApplicationContext(), Restaurante.class);
        startActivity(it);
    }

    public void Salario(View view){
        Intent it = new Intent(getApplicationContext(), Salario.class);
        startActivity(it);
    }

    public void Compras(View view){
        Intent it = new Intent(getApplicationContext(), Compras.class);
        startActivity(it);
    }

}