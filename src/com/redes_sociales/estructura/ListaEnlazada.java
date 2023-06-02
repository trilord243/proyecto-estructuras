package com.redes_sociales.estructura;

/**
 * Esta clase representa una lista enlazada genérica.
 * Utiliza nodos para almacenar los elementos de la lista.
 *
 * @param <T> el tipo de elementos que se almacenarán en la lista.
 */


public class ListaEnlazada<T> {
    private Nodo<T> head;
    private int size = 0; 

    
        /**
     * Agrega un elemento al final de la lista.
     *
     * @param data el elemento a agregar a la lista.
     */
    public void add(T data) {
        Nodo<T> newNode = new Nodo<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Nodo<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++; 
    }
        /**
     * Devuelve el elemento en la posición especificada en la lista.
     *
     * @param index la posición del elemento a devolver.
     * @return el elemento en la posición especificada en la lista.
     */


    public T get(int index) {
        Nodo<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                return null;
            }
            current = current.getNext();
        }
        return current != null ? current.getData() : null;
    }
    
        /**
     * Elimina la primera ocurrencia del elemento especificado de la lista, si está presente.
     *
     * @param data el elemento a eliminar de la lista, si está presente.
     * @return true si la lista contenía el elemento especificado.
     */

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }
        if (head.getData().equals(data)) {
            head = head.getNext();
            size--; 
            return true;
        } else {
            Nodo<T> current = head;
            while (current.getNext() != null) {
                if (current.getNext().getData().equals(data)) {
                    current.setNext(current.getNext().getNext());
                    size--; 
                    return true;
                }
                current = current.getNext();
            }
            return false;
        }
    }
    
       /**
     * Devuelve el primer nodo de la lista.
     *
     * @return el primer nodo de la lista.
     */
    public Nodo<T> getPrimero() {
        return head;
    }
    /**
     * Devuelve el número de elementos en la lista.
     *
     * @return el número de elementos en la lista.
     */
    public int size() {
        return size;
    }
    
    
        /**
     * Devuelve true si la lista contiene el elemento especificado.
     *
     * @param data el elemento cuya presencia en la lista se va a probar.
     * @return true si la lista contiene el elemento especificado.
     */
    public boolean contains(T data) {
    Nodo<T> current = head;
    while (current != null) {
        if (current.getData().equals(data)) {
            return true;
        }
        current = current.getNext();
    }
    return false;
}
        /**
     * Devuelve el índice de la primera ocurrencia del elemento especificado en la lista, o -1 si la lista no contiene el elemento.
     *
     * @param element el elemento a buscar en la lista.
     * @return el índice de la primera ocurrencia del elemento especificado en la lista, o -1 si la lista no contiene el elemento.
     */
    public int indexOf(T element) {
    Nodo<T> current = head;
    int index = 0;
    while (current != null) {
        if (current.getData().equals(element)) {
            return index;
        }
        current = current.getNext();
        index++;
    }
    return -1; }

        /**
     * Inserta el elemento especificado al principio de la lista.
     *
     * @param data el elemento a agregar.
     */
public void addFirst(T data) {
    Nodo<T> newNode = new Nodo<>(data);
    newNode.setNext(head);
    head = newNode;
    size++;
}
    /**
     * Elimina y devuelve el primer elemento de la lista.
     *
     * @return el primer elemento de la lista.
     */
public T removeFirst() {
    if (head == null) {
        return null;
    }
    T data = head.getData();
    head = head.getNext();
    size--;
    return data;
}
    /**
     * Devuelve el primer elemento de la lista.
     *
     * @return el primer elemento de la lista.
     */
public T getFirst() {
    return head != null ? head.getData() : null;
}
   /**
     * Devuelve true si la lista no contiene elementos.
     *
     * @return true si la lista no contiene elementos.
     */
public boolean isEmpty() {
    return size == 0;
}


    /**
     * Agrega el elemento especificado al final de la lista.
     *
     * @param data el elemento a agregar.
     */
public void addLast(T data) {
    Nodo<T> newNode = new Nodo<>(data);
    if (head == null) {
        head = newNode;
    } else {
        Nodo<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }
    size++;
}

}
