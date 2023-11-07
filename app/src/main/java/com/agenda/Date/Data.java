package com.agenda.Date;

import androidx.annotation.NonNull;

public class Data {


    private int mAno;
    private int mMes;
    private int mDia;


    public Data(int ano, int mes, int dia) {
        this.mAno = ano;
        this.mMes = mes;
        this.mDia = dia;
    }


    public void setAno(int ano) {
        this.mAno = ano;
    }

    public int getAno() {
        return this.mAno;
    }

    public void setMes(int mes) {
        this.mMes = mes;
    }

    public int getMes() {
        return this.mMes;
    }

    public void setDia(int dia) {
        this.mDia = dia;
    }

    public int getDia() {
        return this.mDia;
    }


    @NonNull
    @Override
    public String toString() {
        return mAno + "/" + mMes + "/" + mDia;
    }
}
