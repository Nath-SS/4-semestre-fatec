package com.example.aula2802;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculadora extends AppCompatActivity {
    private Button btnCalcular;
    private EditText edtValor1, edtValor2;
    private TextView txtResultado;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);
        edtValor1 = findViewById(R.id.edtValor1);
        edtValor2 = findViewById(R.id.edtValor2);


    }
    public void calcular(View view){
        int v1 = Integer.parseInt(edtValor1.getText().toString());
        int v2 = Integer.parseInt(edtValor2.getText().toString());
        int soma = (v1+v2);
        txtResultado.setText("Resultado: "+soma);
    }
}