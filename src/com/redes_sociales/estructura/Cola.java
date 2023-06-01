package com.redes_sociales.estructura;

public class Cola<T> {
    private ListaEnlazada<T> elementos = new ListaEnlazada<>();

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
