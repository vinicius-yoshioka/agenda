package com.agenda;

import androidx.annotation.Nullable;
import java.util.Observable;

public class NovoCompromissoModel extends Observable {


    private Compromisso compromisso = new Compromisso();


    public NovoCompromissoModel() {}


    public @Nullable String getData() {
        return this.compromisso.getData();
    }

    public void setData(@Nullable String data) {
        this.compromisso.setData(data);
        setChanged();
        notifyObservers();
    }

    public @Nullable String getHora() {
        return this.compromisso.getHora();
    }

    public void setHora(@Nullable String hora) {
        this.compromisso.setHora(hora);
        setChanged();
        notifyObservers();
    }

    public @Nullable String getDescricao() {
        return this.compromisso.getDescricao();
    }

    public void setDescricao(@Nullable String descricao) {
        this.compromisso.setDescricao(descricao);
        setChanged();
        notifyObservers();
    }
}
