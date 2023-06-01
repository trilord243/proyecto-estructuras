package com.redes_sociales.estructura;

public class ListaEnlazada<T> {
    private Nodo<T> head;
    private int size = 0; 

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

    
public void addFirst(T data) {
    Nodo<T> newNode = new Nodo<>(data);
    newNode.setNext(head);
    head = newNode;
    size++;
}

public T removeFirst() {
    if (head == null) {
        return null;
    }
    T data = head.getData();
    head = head.getNext();
    size--;
    return data;
}

public T getFirst() {
    return head != null ? head.getData() : null;
}

public boolean isEmpty() {
    return size == 0;
}
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
