package com.example.appbancodados.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appbancodados.model.Aluno;
import com.example.appbancodados.util.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private ConnectionFactory conexao;
    private SQLiteDatabase banco;
    public AlunoDAO(Context context) {
        //ConnectionFactory com o banco de dados
        conexao = new ConnectionFactory(context, null, null, 0);
        banco = conexao.getWritableDatabase();
    }

    //metodo inserir
    public long insert(Aluno aluno) {
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("cpf", aluno.getCpf());
        values.put("telefone", aluno.getTelefone());
        return(banco.insert("aluno", null, values));
    }

    public List<Aluno> obterTodos() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        Cursor cursor = banco.query("aluno", new String[]{"id", "nome", "cpf",
                        "telefone"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            Aluno a = new Aluno();
            a.setId(cursor.getInt(0));
            a.setNome((cursor.getString(1)));
            a.setCpf((cursor.getString(2)));
            a.setTelefone((((Cursor) cursor).getString(3)));
            alunos.add(a);
        }
        return alunos;
    }
}
