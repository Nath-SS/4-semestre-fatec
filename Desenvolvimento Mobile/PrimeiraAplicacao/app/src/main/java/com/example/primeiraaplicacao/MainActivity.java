package com.example.primeiraaplicacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;
    private Button btnCalcular;
    private EditText edtValor1, edtValor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);
        edtValor1 = findViewById(R.id.edtValor1);
        edtValor2 = findViewById(R.id.edtValor2);
    }

    public void calcular(View view){
        int a = Integer.parseInt(edtValor1.getText().toString());
        int b = Integer.parseInt(edtValor2.getText().toString());
        int soma = (a+b);
        txtResultado.setText("Resultado: " +soma);
    }
}