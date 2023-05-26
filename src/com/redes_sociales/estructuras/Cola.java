/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redes_sociales.estructuras;

/**
 *
 * @author Svetlana Valentina
 */
public class Cola {
    private int size;
    private Nodo front;
    private Nodo back;

    //constructor
    public Cola() {
        this.size = 0;
        this.front = null;
        this.back = null;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the front
     */
    public Nodo getFront() {
        return front;
    }

    /**
     * @param front the front to set
     */
    public void setFront(Nodo front) {
        this.front = front;
    }

    /**
     * @return the back
     */
    public Nodo getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBack(Nodo back) {
        this.back = back;
    }
    
    public boolean esVacio() {
        return this.front == null;
    }
    
    //agregar a la cola
    public void encolar(Object info) {
        Nodo nuevo = new Nodo(info);
        if (esVacio()) {
            this.front = nuevo;
            this.back = nuevo;
            size++;
        } else {
            back.pnext = nuevo;
            back = nuevo;
            size++;
        }
    }
    
    // eliminar de la cola y devolver el indice del vertice
    public Object desencolar() {
        Nodo aux = front;        
        Object index = aux.getData2();
        if (!esVacio()) {
            front = front.pnext;
            size--;
        }
    return index;
    }
    
    //verificar si existe
    public boolean existe(Object info) {
        Nodo aux = front;
        boolean existe;
        if (!esVacio()) {
            desencolar();
            if (aux.getData2() == info) {
                existe = true;
            } else {
                existe = existe(info);
            }
            encolar(aux.getData2());
        } else {
            existe = false;
        }
        return existe;
    }
    
    // copiar cola
    public Cola copy(Cola copia) {
        Object aux;
        if (!esVacio()) {
            aux = front.getData2();
            desencolar();
            copia.encolar(aux);
            copy(copia);
            encolar(aux);
        }
        return copia;
    }
    
    //buscar elemento en cola
    public Object searchElement(int index) {
        Nodo aux = front;
        Object elemento = null;
        if (index > size) {
            System.out.println("No existe en la cola");
        } else if (index > 1) {
            desencolar();
            index--;
            elemento = searchElement(index);
            encolar(aux.getData2());
        } else {
            elemento = front.getData2();
        }
        return elemento;
    }
    
    // mostrar cola
    public void mostrarCola() {
        Nodo temp = front;
        
        while (temp != null) {
            System.out.println(temp.getData2());
            temp = temp.pnext;
        }
        
    }
}
