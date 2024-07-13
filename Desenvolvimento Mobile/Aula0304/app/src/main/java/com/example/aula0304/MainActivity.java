package com.example.aula0304;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtEndereco, edtEmail;

    Button btnSalvar, btnSair, btnLimpar, btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtEndereco = findViewById(R.id.edtEndereco);
        edtEmail = findViewById(R.id.edtEmail);
        btnSair = findViewById(R.id.btnSair);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnRecuperar = findViewById(R.id.btnRecuperar);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void limpar(View view){
        edtNome.setText(null);
        edtEndereco.setText(null);
        edtEmail.setText(null);
    }

    public void salvar(View view)  {
        try {
            FileOutputStream arquivo = openFileOutput(edtNome.getText().toString() + "txt", Context.MODE_PRIVATE);
            OutputStreamWriter fluxo = new OutputStreamWriter(arquivo);
            PrintWriter out = new PrintWriter(fluxo);
            out.println(edtNome.getText().toString());
            out.println(edtEndereco.getText().toString());
            out.println(edtEmail.getText().toString());
            Toast.makeText(this, "Gravado com sucesso", Toast.LENGTH_LONG).show();
            out.close();
            arquivo.close();
        }catch (Exception e){
            Toast.makeText(this, "Erro ao gravar o arquivo", Toast.LENGTH_SHORT).show();
        }
    }


}