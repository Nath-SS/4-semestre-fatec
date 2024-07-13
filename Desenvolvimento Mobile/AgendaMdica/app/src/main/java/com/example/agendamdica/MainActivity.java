package com.example.agendamdica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.agendamdica.dao.ConsultaDao;
import com.example.agendamdica.model.Consulta;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstDados;
    List<Consulta> consultas;
    ConsultaDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstDados = findViewById(R.id.lstDados);
        dao = new ConsultaDao(this);

        lstDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (consultas != null && position < consultas.size()) {
                    Consulta consulta = consultas.get(position);
                    // Criar um Intent para iniciar a Activity de edição
                    Intent intent = new Intent(MainActivity.this, Manutencao.class);

                    // Passar os dados da consulta para a nova Activity
                    intent.putExtra("id", consulta.getId());
                    intent.putExtra("cpf", consulta.getCPF());
                    intent.putExtra("paciente", consulta.getPaciente());
                    intent.putExtra("especialidade", consulta.getEspecialidade());
                    intent.putExtra("medico", consulta.getMedico());
                    intent.putExtra("data", consulta.getData().toString());
                    intent.putExtra("horario", consulta.getHorario());

                    // Iniciar a nova Activity
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(dao != null) {
            listar();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        listar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.itemEditar){
            Intent it = new Intent(this, Manutencao.class );
            startActivity(it);
        }
        if (item.getItemId() == R.id.itemSair){
            finish();
        }
        return true;
    }

    public void listar(){
        consultas = new ArrayList<>(); // Inicialize a lista de consultas aqui
        try {
            consultas = dao.obterTodos();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Criando uma lista de strings para exibir no ListView
        List<String> dadosExibicao = new ArrayList<>();
        for (Consulta consulta : consultas) {
            // Formatando a exibição da consulta para uma string
            String dados = "CPF: " + consulta.getCPF() + "\n" +
                    "Paciente: " + consulta.getPaciente() + "\n" +
                    "Especialidade: " + consulta.getEspecialidade() + "\n" +
                    "Médico: " + consulta.getMedico() + "\n" +
                    "Data: " + consulta.getData() + "\n" +
                    "Horário: " + consulta.getHorario() + "\n";
            dadosExibicao.add(dados);
        }

        // Criando um ArrayAdapter para exibir os dados no ListView
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dadosExibicao);

        // Relacionando o adaptador ao componente ListView
        lstDados.setAdapter(adaptador);
    }
}