package com.agenda.Hora;

import androidx.annotation.NonNull;

public class Hora {


    private int mHora;
    private int mMinuto;


    public Hora(int hora, int minuto) {
        this.mHora = hora;
        this.mMinuto = minuto;
    }


    public void setHora(int hora) {
        this.mHora = hora;
    }

    public int getHora() {
        return this.mHora;
    }

    public void setMinuto(int minuto) {
        this.mMinuto = minuto;
    }

    public int getMinuto() {
        return this.mMinuto;
    }


    @NonNull
    @Override
    public String toString() {
        return mHora + ":" + mMinuto;
    }
}
