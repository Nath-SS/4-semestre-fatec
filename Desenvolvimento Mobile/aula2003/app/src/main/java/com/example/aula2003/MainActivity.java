package com.example.aula2003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView lvwDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvwDados = findViewById(R.id.lvwDados);

        String[] nomes = {"Fulano", "Ciclano", "Beltrano", "Astrolabio", "Astrogildo", "Xincrano", "Josefina", "Roque"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, nomes);
        lvwDados.setAdapter(adaptador);

        lvwDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = String.valueOf(parent.getAdapter().getItem(position));
                Toast.makeText(getApplicationContext(), nome, Toast.LENGTH_SHORT).show();
            }
        });
    }
}