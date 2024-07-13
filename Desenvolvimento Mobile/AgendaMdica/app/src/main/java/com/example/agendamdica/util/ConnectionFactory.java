package com.example.agendamdica.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectionFactory extends SQLiteOpenHelper {

    private static final String NAME = "banco.db";
    private static final int VERSION = 1;


    public ConnectionFactory(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, @Nullable int version){
        super(context, NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table consulta(id integer primary key autoincrement, " +
                "CPF varchar(15), paciente varchar(50), especialidade varchar(100), medico varchar(50), data date, horario varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS consulta";
        db.execSQL(sql);
        onCreate(db);
    }
}