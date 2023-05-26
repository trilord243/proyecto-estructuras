/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redes_sociales.estructuras;

/**
 *
 * @author Svetlana Valentina
 */
public class Nodo {
    protected Nodo pnext;
    protected Usuario data;
    protected Object data2;
    private String[] edges;

    public Nodo(Usuario data) {
        this.pnext = null;
        this.data = data;
    }

    public Nodo(Object data2) {
        this.pnext = null;
        this.data2 = data2;
    }

    /**
     * @return the pnext
     */
    public Nodo getPnext() {
        return pnext;
    }

    /**
     * @param pnext the pnext to set
     */
    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }

    /**
     * @return the data
     */
    public Usuario getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Usuario data) {
        this.data = data;
    }

    /**
     * @return the data2
     */
    public Object getData2() {
        return data2;
    }

    /**
     * @param data2 the data2 to set
     */
    public void setData2(Object data2) {
        this.data2 = data2;
    }
    
    
}
