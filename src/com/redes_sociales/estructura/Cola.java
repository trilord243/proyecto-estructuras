package com.redes_sociales.estructura;

import java.util.LinkedList;


public class Cola<T> {
    private LinkedList<T> elementos = new LinkedList<>();

    public void enqueue(T elemento) {
        elementos.addLast(elemento);
    }

    public T dequeue() {
        return elementos.removeFirst();
    }

    public T peek() {
        return elementos.getFirst();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}