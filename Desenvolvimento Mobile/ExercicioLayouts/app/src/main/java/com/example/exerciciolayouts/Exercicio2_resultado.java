package com.example.exerciciolayouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercicio2_resultado extends AppCompatActivity {

    ImageView imgvReacao;
    Button btnSair2_1, btnReiniciar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercicio2_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgvReacao = findViewById(R.id.imgvReacao);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        btnSair2_1 = findViewById(R.id.btnSair2_1);
        txtResultado = findViewById(R.id.txtResultado);

        btnSair2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        resultado();

    }

    public void resultado(){
        int pontos = Exercicio2.getPontos();
        txtResultado.setText("Pontos: " + pontos + "/5");
        if (pontos >= 3){
            imgvReacao.setImageResource(R.drawable.guttsapproves);
        }
    }

    public void reiniciar(View view){
        Exercicio2.setPontos(0);
        Intent it = new Intent(getApplicationContext(), Exercicio2.class);
        startActivity(it);
        finish();
    }



}