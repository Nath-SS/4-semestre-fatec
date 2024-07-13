package com.example.quizbandeiras;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView imgvUsuario, imgvAluno;
    Button btnSelecionarImagem, btnSair, btnIniciar;

    EditText edtNomeUsuario;

    ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgvUsuario = findViewById(R.id.imgvUsuario);
        imgvAluno = findViewById(R.id.imgvAluno);
        btnSelecionarImagem = findViewById(R.id.btnSelecionarImagem);
        btnSair = findViewById(R.id.btnSair);
        btnIniciar = findViewById(R.id.btnIniciar);
        edtNomeUsuario = findViewById(R.id.edtNomeUsuario);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgvAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent it = new Intent(getApplicationContext(), ModoDificil.class);
                startActivity(it);*/
                UserManager.clearAllPreferences(getApplicationContext());
            }
        });


        edtNomeUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()){
                    btnIniciar.setEnabled(false);
                }else{
                    btnIniciar.setEnabled(true);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnIniciar.setEnabled(false);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pegando ultimo id criado
                int ultimoId = UserManager.loadId(getApplicationContext());

                //criando um novo id
                int novoId = ultimoId+1;

                //Salvando id mais recente
                UserManager.saveUserId(getApplicationContext(), String.valueOf(novoId));

                //Pegando nome do novo jogador
                String nomeUsuario = edtNomeUsuario.getText().toString();

                //Salvando o nome do jogador
                UserManager.saveUsername(MainActivity.this, String.valueOf(novoId), nomeUsuario);

                //Seguindo para a próxima tela
                Intent it = new Intent(getApplicationContext(), Pergunta.class);
                startActivity(it);
            }
        });

        registerResult();
    }

    public void selecionarImagem(View view) {
        Intent intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
        resultLauncher.launch(intent);
    }

    private void registerResult(){
        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        try {
                            Uri imageUri = result.getData().getData();
                            imgvUsuario.setImageURI(imageUri);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this, "Nenhuma imagem selecionada", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
    }

}