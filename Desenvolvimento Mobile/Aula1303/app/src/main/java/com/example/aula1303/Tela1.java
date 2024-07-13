package com.example.aula1303;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tela1 extends AppCompatActivity {

    TextView txtNome;
    Button btnSair2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        btnSair2 = findViewById(R.id.btnSair2);
        txtNome = findViewById(R.id.txtNome);

        Intent it = getIntent();
        String nome = it.getStringExtra("nome");
        txtNome.setText(nome);

        btnSair2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}