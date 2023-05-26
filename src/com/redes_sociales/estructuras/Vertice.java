/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redes_sociales.estructuras;

/**
 *
 * @author Svetlana Valentina
 */
public class Vertice {
    private String nombre; //asignarle un nombre al vertice
    private int index; // asignarle un numero al vertice
    private Lista usuarios; // lista de usuarios

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.index = -1;
        this.usuarios = new Lista();
    }

    /**
     * @return the nombre
     */
    
    // getters y setters
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the usuarios
     */
    public Lista getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Lista usuarios) {
        this.usuarios = usuarios;
    }
    
    //revisa si el vertice ya existe
    public boolean comparar(Vertice n){
        return this.nombre.equals(n.getNombre());
    }
    
}
