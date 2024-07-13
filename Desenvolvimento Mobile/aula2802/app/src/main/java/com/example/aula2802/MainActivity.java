package com.example.aula2802;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button btnCalculadora, btnMercado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculadora = findViewById(R.id.btnCalculadora);
        btnMercado = findViewById(R.id.btnMercado);


    }

    public void chama_tela2(View view) {
        Intent it = new Intent(getApplicationContext(), calculadora.class);
        startActivity(it);
    }
    public void chama_tela3(View view) {
        Intent it = new Intent(getApplicationContext(), mercado.class);
        startActivity(it);
    }
}