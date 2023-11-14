package com.agenda.compromisso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.agenda.Data.Data;
import com.agenda.Hora.Hora;

public class CompromissosDb {


    private Context mContext;
    private SQLiteDatabase mDatabase;


    public CompromissosDb(Context context) {
        mContext = context;
        mDatabase = new CompromissosDbHelper(context).getWritableDatabase();
    }


    private static ContentValues getValoresConteudo(Compromisso compromisso) {
        ContentValues valores = new ContentValues();

        valores.put(CompromissosDbSchema.CompromissosRegistrados.Colunas.descricao, compromisso.getDescricao());

        Data data = compromisso.getData();
        valores.put(CompromissosDbSchema.CompromissosRegistrados.Colunas.ano, data.getAno());
        valores.put(CompromissosDbSchema.CompromissosRegistrados.Colunas.mes, data.getMes());
        valores.put(CompromissosDbSchema.CompromissosRegistrados.Colunas.dia, data.getDia());

        Hora hora = compromisso.getHora();
        valores.put(CompromissosDbSchema.CompromissosRegistrados.Colunas.hora, hora.getHora());
        valores.put(CompromissosDbSchema.CompromissosRegistrados.Colunas.minuto, hora.getMinuto());

        return valores;
    }

    public void addCompromisso(Compromisso compromisso) {
        ContentValues valor = getValoresConteudo(compromisso);
        mDatabase.insert(CompromissosDbSchema.CompromissosRegistrados.NOME, null, valor);
    }

    public Cursor getCompromissos() {
        return mDatabase.query(
                CompromissosDbSchema.CompromissosRegistrados.NOME,
                null,
                null,
                null,
                null,
                null,
                CompromissosDbSchema.CompromissosRegistrados.Colunas.ano + "DESC, " +
                        CompromissosDbSchema.CompromissosRegistrados.Colunas.mes + "DESC, " +
                        CompromissosDbSchema.CompromissosRegistrados.Colunas.dia + "DESC, " +
                        CompromissosDbSchema.CompromissosRegistrados.Colunas.hora + "DESC, " +
                        CompromissosDbSchema.CompromissosRegistrados.Colunas.minuto + "DESC"
        );
    }

    public void deleteCompromisso(int id) {
        mDatabase.delete(
                CompromissosDbSchema.CompromissosRegistrados.NOME,
                CompromissosDbSchema.CompromissosRegistrados.Colunas.id + " = ?",
                new String[]{Integer.toString(id)}
        );
    }
}
