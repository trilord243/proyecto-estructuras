package com.redes_sociales.estructura;

/**
 * Esta clase representa una pila (stack) implementada utilizando una lista enlazada.
 * La pila sigue el principio LIFO (Last In, First Out), donde el último elemento agregado es el primero en ser eliminado.
 *
 * @param <T> el tipo de elementos que se almacenarán en la pila.
 */

public class Pila<T> {
    private ListaEnlazada<T> elementos = new ListaEnlazada<>();
    
    
        /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param elemento el elemento a agregar.
     */

    public void push(T elemento) {
        elementos.addFirst(elemento);
    }
    
        /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return el elemento en la cima de la pila, o null si la pila está vacía.
     */

    public T pop() {
        return elementos.removeFirst();
    }
    
    
        /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     *
     * @return el elemento en la cima de la pila, o null si la pila está vacía.
     */

    public T peek() {
        return elementos.getFirst();
    }
    
        /**
     * Comprueba si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}
