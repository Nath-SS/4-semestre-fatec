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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agendamdica.dao.ConsultaDao;
import com.example.agendamdica.model.Consulta;

public class Manutencao extends AppCompatActivity {

    EditText edtCPF, edtPaciente, edtEspecialidade, edtMedico, edtData, edtHorario;

    Button btnSalvar, btnAlterar, btnExcluir;

    private ConsultaDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manutencao);

        edtCPF = findViewById(R.id.edtCPF);
        edtPaciente = findViewById(R.id.edtPaciente);
        edtEspecialidade = findViewById(R.id.edtEspecialidade);
        edtMedico = findViewById(R.id.edtMedico);
        edtData = findViewById(R.id.edtDia);
        edtHorario = findViewById(R.id.edtHorario);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnAlterar = findViewById(R.id.btnAlterar);
        btnExcluir = findViewById(R.id.btnExcluir);

        Intent intent = getIntent();
        if (intent != null) {
            edtCPF.setText(intent.getStringExtra("cpf"));
            edtPaciente.setText(intent.getStringExtra("paciente"));
            edtEspecialidade.setText(intent.getStringExtra("especialidade"));
            edtMedico.setText(intent.getStringExtra("medico"));
            edtData.setText(intent.getStringExtra("data"));
            edtHorario.setText(intent.getStringExtra("horario"));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_secundario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.itemEditar2){
            Intent it = new Intent(this, Manutencao.class );
            startActivity(it);
            finish();
        }
        if (item.getItemId() == R.id.itemVoltar){
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
            finish();
        }
        if (item.getItemId() == R.id.itemSair2){
            finish();
        }
        return true;
    }

    public void excluir(View view){
         Consulta c = new Consulta();
         c.setCPF(edtCPF.getText().toString());
         dao = new ConsultaDao(this);
         dao.delete(c);
         Toast.makeText(getApplicationContext(), "Consulta cancelada.",Toast.LENGTH_LONG).show();
         finish();
    }

    public void alterar(View view){
        Consulta c = new Consulta();
        c.setCPF(edtCPF.getText().toString());
        c.setPaciente(edtPaciente.getText().toString());
        c.setEspecialidade(edtEspecialidade.getText().toString());
        c.setMedico(edtMedico.getText().toString());
        c.setData(edtData.getText().toString());
        c.setHorario(edtHorario.getText().toString());

        dao = new ConsultaDao(this);
        dao.alterar(c);
        Toast.makeText(getApplicationContext(), "Consulta alterada.", Toast.LENGTH_LONG).show();
        finish();
    }

    public void salvar(View view){
        Consulta c = new Consulta();
        c.setCPF(edtCPF.getText().toString());
        c.setPaciente(edtPaciente.getText().toString());
        c.setEspecialidade(edtEspecialidade.getText().toString());
        c.setMedico(edtMedico.getText().toString());
        c.setData(edtData.getText().toString());
        c.setHorario(edtHorario.getText().toString());

        dao = new ConsultaDao(this);
        dao.salvar(c);
        Toast.makeText(getApplicationContext(), "Consulta agendada!", Toast.LENGTH_LONG).show();
    }


}