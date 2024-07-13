package com.example.aula2802;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class mercado extends AppCompatActivity {

    private CheckBox chkLeite, chkPao;
    private Button btnMostrar;

    private TextView txtMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado);

        chkLeite = findViewById(R.id.chkLeite);
        chkPao = findViewById(R.id.chkPao);
        btnMostrar = findViewById(R.id.btnMostrar);
        txtMostrar = findViewById(R.id.txtMostrar);


    }

    public void mostrar(View view) {
        double soma = 0;

        if (chkLeite.isChecked())
            soma = soma + 4.35;

        if (chkPao.isChecked())
            soma = soma + 9.80;
        txtMostrar.setText("Resultado >> " + soma);
    }
}