package com.agenda.compromisso;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CompromissosDbHelper extends SQLiteOpenHelper {


    private static final String TAG = "CompromissosDbHelper";
    private static final int VERSAO = 1;
    private static final String NOME_DATABASE = "CompromissosDb";


    public CompromissosDbHelper(Context context) {
        super(context, NOME_DATABASE, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");

        db.execSQL("CREATE TABLE " + CompromissosDbSchema.CompromissosRegistrados.NOME + " (" +
                CompromissosDbSchema.CompromissosRegistrados.Colunas.id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CompromissosDbSchema.CompromissosRegistrados.Colunas.ano + " INTEGER NOT NULL," +
                CompromissosDbSchema.CompromissosRegistrados.Colunas.mes + " INTEGER NOT NULL," +
                CompromissosDbSchema.CompromissosRegistrados.Colunas.dia + " INTEGER NOT NULL," +
                CompromissosDbSchema.CompromissosRegistrados.Colunas.hora + " INTEGER NOT NULL," +
                CompromissosDbSchema.CompromissosRegistrados.Colunas.minuto + " INTEGER NOT NULL," +
                CompromissosDbSchema.CompromissosRegistrados.Colunas.descricao + " TEXT NOT NULL)"
        );
        Log.d(TAG, "Tabela " + CompromissosDbSchema.CompromissosRegistrados.NOME + " criada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade");

        db.execSQL("DROP TABLE IF EXISTS " + CompromissosDbSchema.CompromissosRegistrados.NOME);
        onCreate(db);
    }
}
