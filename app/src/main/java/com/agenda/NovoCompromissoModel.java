package com.agenda;

import androidx.annotation.Nullable;
import java.util.Observable;

public class NovoCompromissoModel extends Observable {


    private @Nullable String data;
    private @Nullable String hora;
    private @Nullable String descricao;


    public NovoCompromissoModel() {}


    public @Nullable String getData() {
        return data;
    }

    public void setData(@Nullable String data) {
        this.data = data;
        setChanged();
        notifyObservers();
    }

    public @Nullable String getHora() {
        return hora;
    }

    public void setHora(@Nullable String hora) {
        this.hora = hora;
        setChanged();
        notifyObservers();
    }

    public @Nullable String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Nullable String descricao) {
        this.descricao = descricao;
        setChanged();
        notifyObservers();
    }
}
