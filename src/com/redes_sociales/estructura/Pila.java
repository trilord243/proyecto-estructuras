package com.redes_sociales.estructura;

public class Pila<T> {
    private ListaEnlazada<T> elementos = new ListaEnlazada<>();

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
