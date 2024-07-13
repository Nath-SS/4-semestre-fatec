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

public class Exercicio2 extends AppCompatActivity {

    private int contador = 1;
    static int pontos;

    TextView txtPergunta;

    ImageView imgvPlaca;
    Button btnSair2, btnPlaca1, btnPlaca2, btnPlaca3, btnPlaca4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercicio2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtPergunta = findViewById(R.id.txtPergunta);
        imgvPlaca = findViewById(R.id.imgvPlaca);
        btnSair2 = findViewById(R.id.btnSair2);
        btnPlaca1 = findViewById(R.id.btnPlaca1);
        btnPlaca2 = findViewById(R.id.btnPlaca2);
        btnPlaca3 = findViewById(R.id.btnPlaca3);
        btnPlaca4 = findViewById(R.id.btnPlaca4);

        btnSair2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        Exercicio2.pontos = pontos;
    }
    public void Opçcao1(View view){
        switch(contador){
            case 1: {
                contador++;//2
                txtPergunta.setText("Q2 - Qual o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.placasemaforo);
                btnPlaca1.setText("Semáforo a frente");
                btnPlaca2.setText("Atenção semáforo");
                btnPlaca3.setText("cruzamento a frente");
                btnPlaca4.setText("Atenção cruzamento");
                break;
            }

            case 2: {
                contador++;//3
                pontos++; //2
                txtPergunta.setText("Q3 - Qual o erro dessa placa?");
                imgvPlaca.setImageResource(R.drawable.placacarro);
                btnPlaca1.setText("Ela não está errada");
                btnPlaca2.setText("Essa placa não existe");
                btnPlaca3.setText("O sentido esta errado");
                btnPlaca4.setText("Ela está curvada");
                break;
            }

            case 3: {
                contador++;//4
                txtPergunta.setText("Q4 - Qual o nome correto dessa placa?");
                imgvPlaca.setImageResource(R.drawable.placaestreitamento);
                btnPlaca1.setText("Estreitamento da pista ao centro");
                btnPlaca2.setText("Estreitamento de pista ao centro");
                btnPlaca3.setText("Estreitamento ao centro");
                btnPlaca4.setText("Estreitamento das pistas");
                break;
            }

            case 4: {
                contador++;//5
                txtPergunta.setText("Q5 - Que placa é esta?");
                imgvPlaca.setImageResource(R.drawable.placapassagem);
                btnPlaca1.setText("Trânsito de pedestres");
                btnPlaca2.setText("Passagem sinalizada de pedestres");
                btnPlaca3.setText("Passagem de pedestres a frente");
                btnPlaca4.setText("Atenção, passagem de pedestres");
                break;
            }

            case 5: {
                Intent it = new Intent(getApplicationContext(), Exercicio2_resultado.class);
                startActivity(it);
                finish();
            }
        }

    }

    public void Opçcao2(View view){
        switch(contador){
            case 1: {
                contador++;
                txtPergunta.setText("Q2 - Qual o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.placasemaforo);
                btnPlaca1.setText("Semáforo a frente");
                btnPlaca2.setText("Atenção semáforo");
                btnPlaca3.setText("cruzamento a frente");
                btnPlaca4.setText("Atenção cruzamento");
                break;
            }

            case 2: {
                contador++;
                txtPergunta.setText("Q3 - Qual o erro dessa placa?");
                imgvPlaca.setImageResource(R.drawable.placacarro);
                btnPlaca1.setText("Ela não está errada");
                btnPlaca2.setText("Essa placa não existe");
                btnPlaca3.setText("O sentido esta errado");
                btnPlaca4.setText("Ela está curvada");
                break;
            }

            case 3: {
                contador++;
                txtPergunta.setText("Q4 - Qual o nome correto dessa placa?");
                imgvPlaca.setImageResource(R.drawable.placaestreitamento);
                btnPlaca1.setText("Estreitamento da pista ao centro");
                btnPlaca2.setText("Estreitamento de pista ao centro");
                btnPlaca3.setText("Estreitamento ao centro");
                btnPlaca4.setText("Estreitamento das pistas");
                break;
            }

            case 4: {
                contador++;
                pontos++;
                txtPergunta.setText("Q5 - Que placa é esta?");
                imgvPlaca.setImageResource(R.drawable.placapassagem);
                btnPlaca1.setText("Trânsito de pedestres");
                btnPlaca2.setText("Passagem sinalizada de pedestres");
                btnPlaca3.setText("Passagem de pedestres a frente");
                btnPlaca4.setText("Atenção, passagem de pedestres");
                break;
            }

            case 5: {
                pontos++;
                Intent it = new Intent(getApplicationContext(), Exercicio2_resultado.class);
                startActivity(it);
                finish();
            }
        }

    }

    public void Opçcao3(View view){
        switch(contador){
            case 1: {
                contador++;
                pontos++;
                txtPergunta.setText("Q2 - Qual o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.placasemaforo);
                btnPlaca1.setText("Semáforo a frente");
                btnPlaca2.setText("Atenção semáforo");
                btnPlaca3.setText("cruzamento a frente");
                btnPlaca4.setText("Atenção cruzamento");
                break;
            }

            case 2: {
                contador++;
                txtPergunta.setText("Q3 - Qual o erro dessa placa?");
                imgvPlaca.setImageResource(R.drawable.placacarro);
                btnPlaca1.setText("Ela não está errada");
                btnPlaca2.setText("Essa placa não existe");
                btnPlaca3.setText("O sentido esta errado");
                btnPlaca4.setText("Ela está curvada");
                break;
            }

            case 3: {
                contador++;
                txtPergunta.setText("Q4 - Qual o nome correto dessa placa?");
                imgvPlaca.setImageResource(R.drawable.placaestreitamento);
                btnPlaca1.setText("Estreitamento da pista ao centro");
                btnPlaca2.setText("Estreitamento de pista ao centro");
                btnPlaca3.setText("Estreitamento ao centro");
                btnPlaca4.setText("Estreitamento das pistas");
                break;
            }

            case 4: {
                contador++;
                txtPergunta.setText("Q5 - Que placa é esta?");
                imgvPlaca.setImageResource(R.drawable.placapassagem);
                btnPlaca1.setText("Trânsito de pedestres");
                btnPlaca2.setText("Passagem sinalizada de pedestres");
                btnPlaca3.setText("Passagem de pedestres a frente");
                btnPlaca4.setText("Atenção, passagem de pedestres");
                break;
            }

            case 5: {
                Intent it = new Intent(getApplicationContext(), Exercicio2_resultado.class);
                startActivity(it);
                finish();
            }
        }

    }

    public void Opçcao4(View view){
        switch(contador){
            case 1: {
                contador++;
                txtPergunta.setText("Q2 - Qual o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.placasemaforo);
                btnPlaca1.setText("Semáforo a frente");
                btnPlaca2.setText("Atenção semáforo");
                btnPlaca3.setText("cruzamento a frente");
                btnPlaca4.setText("Atenção cruzamento");
                break;
            }

            case 2: {
                contador++;
                txtPergunta.setText("Q3 - Qual o erro dessa placa?");
                imgvPlaca.setImageResource(R.drawable.placacarro);
                btnPlaca1.setText("Ela não está errada");
                btnPlaca2.setText("Essa placa não existe");
                btnPlaca3.setText("O sentido esta errado");
                btnPlaca4.setText("Ela está curvada");
                break;
            }

            case 3: {
                contador++;
                pontos++;
                txtPergunta.setText("Q4 - Qual o nome correto dessa placa?");
                imgvPlaca.setImageResource(R.drawable.placaestreitamento);
                btnPlaca1.setText("Estreitamento da pista ao centro");
                btnPlaca2.setText("Estreitamento de pista ao centro");
                btnPlaca3.setText("Estreitamento ao centro");
                btnPlaca4.setText("Estreitamento das pistas");
                break;
            }

            case 4: {
                contador++;
                txtPergunta.setText("Q5 - Que placa é esta?");
                imgvPlaca.setImageResource(R.drawable.placapassagem);
                btnPlaca1.setText("Trânsito de pedestres");
                btnPlaca2.setText("Passagem sinalizada de pedestres");
                btnPlaca3.setText("Passagem de pedestres a frente");
                btnPlaca4.setText("Atenção, passagem de pedestres");
                break;
            }

            case 5: {
                Intent it = new Intent(getApplicationContext(), Exercicio2_resultado.class);
                startActivity(it);
                finish();
            }
        }

    }
}