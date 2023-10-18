package com.agenda;

import java.util.*;

public class Model extends Observable {


    private List<Integer> List;


    public Model() {
        List = new ArrayList<Integer>(3);
        List.add(0);
        List.add(0);
        List.add(0);
    }


    public int getValueAtIndex(final int the_index) throws IndexOutOfBoundsException {
        return List.get(the_index);
    }

    public void setValueAtIndex(final int the_index) throws IndexOutOfBoundsException {
        List.set(the_index,List.get(the_index) + 1);
        notifyObservers();
    }
}
