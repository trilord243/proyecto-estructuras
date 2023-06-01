package com.redes_sociales.estructura;

import java.util.LinkedList;

public class Pila<T> {
    private LinkedList<T> elementos = new LinkedList<>();

    public void push(T elemento) {
        elementos.addFirst(elemento);
    }

    public T pop() {
        return elementos.removeFirst();
    }

    public T peek() {
        return elementos.getFirst();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}


