package com.example.agendamdica.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.agendamdica.model.Consulta;
import com.example.agendamdica.util.ConnectionFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultaDao {

    private ConnectionFactory conexao;
    private SQLiteDatabase banco;

    public ConsultaDao(Context context){
        conexao = new ConnectionFactory(context, null, null, 0);
        banco = conexao.getWritableDatabase();
    }

    public long salvar(Consulta consulta){
        ContentValues values = new ContentValues();
        values.put("cpf", consulta.getCPF());
        values.put("paciente", consulta.getPaciente());
        values.put("especialidade", consulta.getEspecialidade());
        values.put("medico", consulta.getMedico());
        values.put("data", consulta.getData());
        values.put("horario", consulta.getHorario());
        return(banco.insert("consulta", null, values));
    }

    public void alterar(Consulta consulta){
        ContentValues values = new ContentValues();
        values.put("cpf", consulta.getCPF());
        values.put("paciente", consulta.getPaciente());
        values.put("especialidade", consulta.getEspecialidade());
        values.put("medico", consulta.getMedico());
        values.put("data", consulta.getData());
        values.put("horario", consulta.getHorario());
        String args[] = {String.valueOf(consulta.getCPF())};
        banco.update("consulta", values, "cpf=?", args);
    }

    public void delete(Consulta consulta){
        String args[] = {String.valueOf(consulta.getCPF())};
        banco.delete("consulta","cpf=?",args);
    }

    public List<Consulta> obterTodos() throws ParseException {
        List<Consulta> consultas = new ArrayList<Consulta>();
        Cursor cursor = banco.query("consulta", new String[]{"id", "cpf", "paciente",
                        "especialidade", "medico", "data", "horario"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            Consulta c = new Consulta();
            c.setId(cursor.getInt(0));
            c.setCPF((cursor.getString(1)));
            c.setPaciente((cursor.getString(2)));
            c.setEspecialidade((cursor.getString(3)));
            c.setMedico((cursor.getString(4)));
            c.setData((cursor.getString(5)));
            c.setHorario((cursor.getString(6)));
            consultas.add(c);
        }
        return consultas;
    }

    public Consulta read(Integer id) throws ParseException {
        String args[] = {String.valueOf(id)};
        Cursor cursor = banco.query("consulta", new String[]{"id", "cpf", "paciente",
                        "especialidade", "medico", "data", "horario"}, "cpf=?", args, null, null, null);
        cursor.moveToFirst();
        Consulta consulta = new Consulta();
        if(cursor.getCount() > 0){
            consulta.setId(cursor.getInt(0));
            consulta.setCPF((cursor.getString(1)));
            consulta.setPaciente((cursor.getString(2)));
            consulta.setEspecialidade((cursor.getString(3)));
            consulta.setMedico((cursor.getString(4)));
            consulta.setData((cursor.getString(5)));
            consulta.setHorario((cursor.getString(6)));
        }
        return consulta;
    }
}
