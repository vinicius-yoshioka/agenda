package com.agenda;

import androidx.annotation.Nullable;

public class Compromisso {


    private @Nullable String data;
    private @Nullable String hora;
    private @Nullable String descricao;


    public @Nullable String getData() {
        return data;
    }

    public void setData(@Nullable String data) {
        this.data = data;
    }

    public @Nullable String getHora() {
        return hora;
    }

    public void setHora(@Nullable String hora) {
        this.hora = hora;
    }

    public @Nullable String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Nullable String descricao) {
        this.descricao = descricao;
    }
}
