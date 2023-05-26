/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redes_sociales.estructuras;

/**
 *
 * @author Svetlana Valentina
 */
public class Pila {
    private Nodo top;
    private int size;

    //constructor
    public Pila() {
        this.top = null;
        this.size = 0;
    }

    /**
     * @return the top
     */
    public Nodo getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(Nodo top) {
        this.top = top;
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
    
    public boolean isEmpty() {
        return top == null;
    }
    
    //Apilar
    public void apilar(Object dato) {
        Nodo aux = new Nodo(dato);
        aux.setPnext(this.top);
        setTop(aux);
        size++;
    }
    
    //desapilar
    public Object desapilar() {
        Object info = top.getData2();
        this.top = top.getPnext();
        size--;
    return info;
    }
    
    public Object top() {
        return top.getData2();
    }
    
    public void mostrarPila() {       
        Nodo pAux = this.top;
        while (pAux != null) {
            System.out.println(pAux.getData2());
            pAux = pAux.getPnext();
        }
        
    }
    
    public void sumergir(Object x) {
        if (!isEmpty()) {
            Object aux = this.desapilar();
            this.sumergir(x);
            this.apilar(aux);
        } else {
            this.apilar(x);
        }
    }
    
    public void invertirPila() {
        if (!isEmpty()) {
            Object aux = this.desapilar();
            this.invertirPila();
            this.sumergir(aux);
        }
    }
    
    public void vaciarPila() {
        while (!isEmpty()) {
            this.desapilar();
        }
    }
    
}
