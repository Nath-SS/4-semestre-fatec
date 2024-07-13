package com.example.atividadepratica1;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Salario extends AppCompatActivity {

    EditText edtSalario;

    Button btnVoltar3, btnNovoSalario;

    RadioButton rdb40, rdb45, rdb50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        edtSalario = findViewById(R.id.edtSalario);
        btnVoltar3 = findViewById(R.id.btnVoltar3);
        btnNovoSalario = findViewById(R.id.btnNovoSalario);
        rdb40 = findViewById(R.id.rdb40);
        rdb45 = findViewById(R.id.rdb45);
        rdb50 = findViewById(R.id.rdb50);

        btnVoltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void CalculaSalario(View view){
        Double salario = parseDouble(String.valueOf(edtSalario.getText()));
        if(rdb40.isChecked()){
            double porcentagem = (salario*40)/100;
            double novoSalario = salario+porcentagem;
            edtSalario.setText(Double.toString(novoSalario));
        }else if(rdb45.isChecked()) {
            double porcentagem = (salario*45)/100;
            double novoSalario = salario+porcentagem;
            edtSalario.setText(Double.toString(novoSalario));
        }else if(rdb50.isChecked()) {
            double porcentagem = (salario*50)/100;
            double novoSalario = salario+porcentagem;
            edtSalario.setText(Double.toString(novoSalario));
        }else{
            edtSalario.setText("Por favor selecione um percentual.");
        }
    }

}