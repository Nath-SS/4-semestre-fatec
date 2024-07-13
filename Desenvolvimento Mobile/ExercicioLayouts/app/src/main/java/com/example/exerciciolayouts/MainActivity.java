package com.example.exerciciolayouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnEx1, btnEx2, btnEx3, btnEx4, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnEx1 = findViewById(R.id.btnEx1);
        btnEx2 = findViewById(R.id.btnEx2);
        btnEx3 = findViewById(R.id.btnEx3);
        btnEx4 = findViewById(R.id.btnEx4);
        btnSair = findViewById(R.id.btnSair);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void Exercicio1(View view){
        Intent it = new Intent(getApplicationContext(), Exercicio1.class);
        startActivity(it);
    }

    public void Exercicio2(View view){
        Intent it = new Intent(getApplicationContext(), Exercicio2.class);
        startActivity(it);
    }

    public void Exercicio3(View view){
        Intent it = new Intent(getApplicationContext(), Exercicio3.class);
        startActivity(it);
    }

    public void Exercicio4(View view){
        Intent it = new Intent(getApplicationContext(), Exercicio4.class);
        startActivity(it);
    }
}