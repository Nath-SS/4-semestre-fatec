package com.example.atividadepratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Restaurante extends AppCompatActivity {

    EditText edtConsumo, edtCouvert, edtDivisao, edtTaxa, edtContaTotal, edtValorPessoa;

    Button btnContaFinal, btnVoltar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        edtConsumo = findViewById(R.id.edtConsumo);
        edtCouvert = findViewById(R.id.edtCouvert);
        edtDivisao = findViewById(R.id.edtDivisao);
        edtTaxa = findViewById(R.id.edtTaxa);
        edtContaTotal = findViewById(R.id.edtContaTotal);
        edtValorPessoa = findViewById(R.id.edtValorPessoa);
        btnContaFinal = findViewById(R.id.btnContaFinal);
        btnVoltar4 = findViewById(R.id.btnVoltar4);

        btnVoltar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void CalculaTotal(View view){

        //Pegando o valor de 10% do consumo
        String consumo = edtConsumo.getText().toString();

        double taxa = (Double.parseDouble(consumo)*10)/100;

        //Pegando couvert artistico
        double couvert = Double.parseDouble(edtCouvert.getText().toString());

        //Pegando o valor da conta total
        double consumoTotal = Double.parseDouble(consumo)+taxa + couvert;

        //Pegando valor por pessoa
        String divisao = edtDivisao.getText().toString();


        // Taxa de serviço
        edtTaxa.setText(String.valueOf(taxa));

        // Conta total
        //Acrescentando o valor do couvert
        edtContaTotal.setText(String.valueOf(consumoTotal));

        // Valor por pessoa
        if(divisao.isEmpty()){
            edtValorPessoa.setText(String.valueOf(consumoTotal));
        }else{
            double qntdPessoa = consumoTotal / Integer.parseInt(divisao);
            edtValorPessoa.setText(String.valueOf(qntdPessoa));
        }
    }
}