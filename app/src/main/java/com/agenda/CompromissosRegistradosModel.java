package com.agenda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;

public class CompromissosRegistradosModel extends Observable {


    private List<Compromisso> compromissosRegistrados = new ArrayList<>();


    public CompromissosRegistradosModel() {}


    public List<Compromisso> getCompromissos() {
        return compromissosRegistrados;
    }

    public void addCompromisso(Compromisso compromisso) {
        this.compromissosRegistrados.add(compromisso);
        setChanged();
        notifyObservers();
    }

    public void addCompromissos(Collection<? extends Compromisso> compromissos) {
        this.compromissosRegistrados.addAll(compromissos);
        setChanged();
        notifyObservers();
    }
}
