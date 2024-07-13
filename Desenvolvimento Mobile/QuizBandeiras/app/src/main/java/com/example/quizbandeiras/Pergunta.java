package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Pergunta extends AppCompatActivity {

    private int pergunta = 1;

    static int pontos = 0;

    TextView txtPergunta;
    ImageView imgvBandeira;

    RadioButton rdbOpcao1, rdbOpcao2, rdbOpcao3, rdbOpcao4;

    Button btnResponder, btnSair2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);

        txtPergunta = findViewById(R.id.txtPergunta);
        imgvBandeira = findViewById(R.id.imgvBandeira);
        rdbOpcao1 = findViewById(R.id.rdbOpcao1);
        rdbOpcao2 = findViewById(R.id.rdbOpcao2);
        rdbOpcao3 = findViewById(R.id.rdbOpcao3);
        rdbOpcao4 = findViewById(R.id.rdbOpcao4);
        btnResponder = findViewById(R.id.btnResponder);
        btnSair2 = findViewById(R.id.btnSair2);

        btnSair2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pontos = 0;
                pergunta = 1;
                finish();
            }
        });

    }


    public void proximaPergunta(View view){
        switch(pergunta){
            case 1:{
                pergunta++;
                if (rdbOpcao1.isChecked() || rdbOpcao4.isChecked()){
                    pontos++;
                }
                imgvBandeira.setImageResource(R.drawable.estragosunidos); //colocar próxima bandeira
                txtPergunta.setText("2/10 - Que país é este?");
                rdbOpcao1.setText("Estados Unidos da America");
                rdbOpcao2.setText("USA");
                rdbOpcao3.setText("Estados Unidos");
                rdbOpcao4.setText("Estragos Unidos");
                break;
            }
            case 2:{
                pergunta++;
                if (rdbOpcao1.isChecked()){
                    pontos++;
                }
                imgvBandeira.setImageResource(R.drawable.ingraterra); // colocar próxima bandeira
                txtPergunta.setText("3/10 - Que país é este?");
                rdbOpcao1.setText("Ingratera");
                rdbOpcao2.setText("Inglatera");
                rdbOpcao3.setText("Ingraterra");
                rdbOpcao4.setText("Inglaterra");
                break;
            }
            case 3:{
                pergunta++;
                if (rdbOpcao4.isChecked()){
                    pontos++;
                }
                imgvBandeira.setImageResource(R.drawable.australha); //colocar próxima bandeira
                txtPergunta.setText("4/10 - Que país é este?");
                rdbOpcao1.setText("Áustralha");
                rdbOpcao2.setText("Áustralia");
                rdbOpcao3.setText("Austrálha");
                rdbOpcao4.setText("Austrália");
                break;
            }
            case 4:{
                pergunta++;
                if (rdbOpcao4.isChecked()){
                    pontos++;
                }
                imgvBandeira.setImageResource(R.drawable.argentinha); //colocar próxima bandeira
                txtPergunta.setText("5/10 - Que país é este?");
                rdbOpcao1.setText("Argentinha");
                rdbOpcao2.setText("Argentína");
                rdbOpcao3.setText("Argentina");
                rdbOpcao4.setText("Agentina");
                break;
            }
            case 5:{
                pergunta++;
                if (rdbOpcao3.isChecked()){
                    pontos++;
                }
                imgvBandeira.setImageResource(R.drawable.libera); //colocar próxima bandeira
                txtPergunta.setText("6/10 - Que país é este?");
                rdbOpcao1.setText("Liberia");
                rdbOpcao2.setText("Estados Unidos da America");
                rdbOpcao3.setText("Malásia");
                rdbOpcao4.setText("Maranhão");
                break;
            }
            case 6:{
                pergunta++;
                if (rdbOpcao1.isChecked()){
                    pontos++;
                }
                imgvBandeira.setImageResource(R.drawable.equedor); //colocar próxima bandeira
                txtPergunta.setText("7/10 - Que país é este?");
                rdbOpcao1.setText("Romênia");
                rdbOpcao2.setText("Colombia");
                rdbOpcao3.setText("Venezuela");
                rdbOpcao4.setText("Equador");
                break;
            }
            case 7:{
                pergunta++;
                if (rdbOpcao4.isChecked()){
                    pontos++;
                }
                imgvBandeira.setImageResource(R.drawable.camarao); //colocar próxima bandeira
                txtPergunta.setText("8/10 - Que país é este?");
                rdbOpcao1.setText("Guiné");
                rdbOpcao2.setText("Camarões");
                rdbOpcao3.setText("Senegal");
                rdbOpcao4.setText("Mali");
                break;
            }
            case 8:{
                pergunta++;
                if (rdbOpcao2.isChecked()){
                    pontos++;
                }
                imgvBandeira.setImageResource(R.drawable.egito); //colocar próxima bandeira
                txtPergunta.setText("9/10 - Que país é este?");
                rdbOpcao1.setText("Iraque");
                rdbOpcao2.setText("Síria");
                rdbOpcao3.setText("Egito");
                rdbOpcao4.setText("Lêmen");
                break;
            }
            case 9:{
                pergunta++;
                if (rdbOpcao3.isChecked()){
                    pontos++;
                }
                imgvBandeira.setImageResource(R.drawable.urss); //colocar próxima bandeira
                txtPergunta.setText("10/10 - Que país é este?");
                rdbOpcao1.setText("Paraguai");
                rdbOpcao2.setText("Sérvia");
                rdbOpcao3.setText("Rússia");
                rdbOpcao4.setText("Holanda");
                break;
            }
            case 10:{
                if (rdbOpcao3.isChecked()){
                    pontos++;
                }
                //Pegando id do usuário
                String id = String.valueOf(UserManager.loadId(getApplicationContext()));

                //Salvando pontos do usuário
                UserManager.saveUserPoints(getApplicationContext(), id, pontos);

                //Zerando os pontos
                pontos = 0;

                //Trocando de tela
                Intent it = new Intent(getApplicationContext(), Resultado.class);
                startActivity(it);
                finish();
            }
        }
    }


}