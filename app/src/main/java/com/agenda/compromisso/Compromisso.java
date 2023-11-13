package com.agenda.compromisso;

import androidx.annotation.Nullable;
import com.agenda.Date.Data;
import com.agenda.Hora.Hora;

public class Compromisso {


    private @Nullable Data data;
    private @Nullable Hora hora;
    private @Nullable String descricao;


    public @Nullable Data getData() {
        return data;
    }

    public void setData(@Nullable Data data) {
        this.data = data;
    }

    public @Nullable Hora getHora() {
        return hora;
    }

    public void setHora(@Nullable Hora hora) {
        this.hora = hora;
    }

    public @Nullable String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Nullable String descricao) {
        this.descricao = descricao;
    }
}
