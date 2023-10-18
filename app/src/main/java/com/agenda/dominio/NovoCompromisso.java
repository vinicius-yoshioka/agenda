package com.agenda.dominio;


public class NovoCompromisso {


    private String data;
    private String hora;
    private String descricao;


    public NovoCompromisso(String data, String hora, String descricao) {
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
