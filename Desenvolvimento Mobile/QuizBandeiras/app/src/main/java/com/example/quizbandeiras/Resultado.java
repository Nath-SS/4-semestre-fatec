package com.example.quizbandeiras;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Resultado extends AppCompatActivity {

    LinearLayout ranking;

    TextView txtUsuario, txtPontos;

    Button btnMenuPrincipal, btnReiniciar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String id = String.valueOf(UserManager.loadId(getApplicationContext()));
        ranking = findViewById(R.id.ranking);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtPontos = findViewById(R.id.txtPontos);
        btnMenuPrincipal = findViewById(R.id.btnMenuPrincipal);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        Map<String, Integer> usersWithPoints = UserManager.getAllUsersWithPoints(this);

        txtUsuario.setText(UserManager.getUsername(this, id));
        txtPontos.setText(UserManager.loadUserPoints(this, id));


        // Exibe os dados na interface do usuário (TextViews dinâmicos)
        for (Map.Entry<String, Integer> entry : usersWithPoints.entrySet()) {
            String userId = entry.getKey();
            int points = entry.getValue();

            // Recupera o nome do usuário correspondente ao ID
            String username = UserManager.getUsername(this, userId);

            // Cria um novo TextView para exibir os dados do usuário
            TextView textView = new TextView(this);
            textView.setText(username + " --------- " + points);
            textView.setTextSize(16); // Tamanho do texto em sp
            textView.setPadding(5, 5, 5, 5); // Espaçamento em pixels
            textView.setTextColor(Color.parseColor("#FFFFFF")); // Cor do texto

            // Adiciona o TextView ao layout
            ranking.addView(textView);
        }

        btnMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
                finish();
            }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), Pergunta.class);
                startActivity(it);
                finish();
            }
        });
    }
}