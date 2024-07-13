package com.example.aula1004;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText edtDestinatario, edtAssunto, edtMensagem;
    Button btnEnviar, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtAssunto = findViewById(R.id.edtAssunto);
        edtMensagem = findViewById(R.id.edtMensagem);
        edtDestinatario = findViewById(R.id.edtDestinatario);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnSair = findViewById(R.id.btnSair);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void enviar(View view){
        String destinatario = edtDestinatario.getText().toString();
        String assunto = edtAssunto.getText().toString();
        String mensagem = edtMensagem.getText().toString();
        // abre tela do email
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(intent.EXTRA_EMAIL, new String[]{destinatario});
        intent.putExtra(intent.EXTRA_SUBJECT,assunto);
        intent.putExtra(intent.EXTRA_TEXT,mensagem);
        // rfc822 padrao mundial de mensagem
        intent.setType("message/rfc822");
        startActivity(intent.createChooser(intent, "Selecione um aplicativo"));
    }
}