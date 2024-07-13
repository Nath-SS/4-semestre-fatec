package com.example.aula1303;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Criar componentes

    EditText edtNome;
    Button btnEnviar, btnTela1, btnTela2, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnTela1 = findViewById(R.id.btnTela1);
        btnTela2 = findViewById(R.id.btnTela2);
        btnSair = findViewById(R.id.btnSair);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void enviar(View view){
        Intent it = new Intent(getApplicationContext(), Tela1.class);
        it.putExtra("nome", edtNome.getText().toString());
        startActivity(it);
    }


}