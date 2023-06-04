package com.redes_sociales.estructura;
/**
 * Esta clase representa un nodo en una lista enlazada.
 * Cada nodo almacena un dato y una referencia al siguiente nodo en la lista.
 *
 * @param <T> el tipo de elemento que se almacenará en el nodo.
 */

public class Nodo<T> {
    private T data;
    private Nodo<T> next;
    /**
     * Metodo constructor de la clase Nodo 
     *
     * @param data el dato a almacenar en el nodo.
     */
    public Nodo(T data) {
        this.data = data;
    }
        /**
     * Devuelve el dato almacenado en el nodo.
     *
     * @return el dato almacenado en el nodo.
     */
    public T getData() {
        return data;
    }
        /**
     * Establece el dato del nodo.
     *
     * @param data el dato a establecer.
     */
    public void setData(T data) {
        this.data = data;
    }
    
       /**
     * Devuelve el siguiente nodo en la lista.
     *
     * @return el siguiente nodo en la lista.
     */

    public Nodo<T> getNext() {
        return next;
    }
    
        /**
     * Establece el siguiente nodo en la lista.
     *
     * @param next el siguiente nodo a establecer.
     */

    public void setNext(Nodo<T> next) {
        this.next = next;
    }
}
