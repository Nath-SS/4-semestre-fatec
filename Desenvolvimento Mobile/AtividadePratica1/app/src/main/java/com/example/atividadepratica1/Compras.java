package com.example.atividadepratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Compras extends AppCompatActivity {

    Button btnCalculaTotal, btnVoltar;
    CheckBox chkArroz, chkLeite, chkCarne, chkFeijao, chkCoca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        chkArroz = findViewById(R.id.chkArroz);
        chkLeite = findViewById(R.id.chkLeite);
        chkCarne = findViewById(R.id.chkCarne);
        chkFeijao = findViewById(R.id.chkFeijao);
        chkCoca = findViewById(R.id.chkCoca);

        btnCalculaTotal = findViewById(R.id.btnCalculaTotal);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnCalculaTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double soma = 0;

                Map<CheckBox, Double> produtos = new HashMap<>();

                produtos.put(chkArroz, 12.35);
                produtos.put(chkLeite, 2.48);
                produtos.put(chkCarne, 23.99);
                produtos.put(chkFeijao, 4.30);
                produtos.put(chkCoca, 5.09);

                for (Map.Entry<CheckBox, Double> entry : produtos.entrySet()) {
                    if (entry.getKey().isChecked()) {
                        soma += entry.getValue();
                    }
                }
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                Toast.makeText(getApplicationContext(), decimalFormat.format(soma), Toast.LENGTH_LONG).show();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}