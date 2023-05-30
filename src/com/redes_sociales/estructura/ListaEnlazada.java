package com.redes_sociales.estructura;

public class ListaEnlazada<T> {
    private Nodo<T> head;
    private int size = 0; // Agregamos un campo para llevar la cuenta del tamaño de la lista

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
        size++; // Incrementamos el tamaño cada vez que agregamos un elemento
    }

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

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }
        if (head.getData().equals(data)) {
            head = head.getNext();
            size--; // Decrementamos el tamaño cada vez que eliminamos un elemento
            return true;
        } else {
            Nodo<T> current = head;
            while (current.getNext() != null) {
                if (current.getNext().getData().equals(data)) {
                    current.setNext(current.getNext().getNext());
                    size--; // Decrementamos el tamaño cada vez que eliminamos un elemento
                    return true;
                }
                current = current.getNext();
            }
            return false;
        }
    }
    
    // Aquí están los nuevos métodos
    public Nodo<T> getPrimero() {
        return head;
    }

    public int size() {
        return size;
    }
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

}
