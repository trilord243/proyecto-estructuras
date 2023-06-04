package com.redes_sociales.estructura;
/**
 * Esta clase representa una cola genérica (queue) (FIFO: First In, First Out).
 * Utiliza una ListaEnlazada para almacenar los elementos de la cola.
 *
 * @param <T> el tipo de elementos que se almacenarán en la cola.
 */
public class Cola<T> {
    private ListaEnlazada<T> elementos = new ListaEnlazada<>();
    
    
        /**
     * Agrega un elemento al final de la cola.
     *
     * @param elemento el elemento a agregar a la cola.
     */
    public void enqueue(T elemento) {
        elementos.addLast(elemento);
    }
    /**
     * Elimina y devuelve el primer elemento de la cola.
     *
     * @return el primer elemento de la cola.
     */
    public T dequeue() {
        return elementos.removeFirst();
    }
    /**
     * Devuelve el primer elemento de la cola sin eliminarlo.
     *
     * @return el primer elemento de la cola.
     */
    public T peek() {
        return elementos.getFirst();
    }
     /**
     * Comprueba si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}
