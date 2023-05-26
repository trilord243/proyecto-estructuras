/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redes_sociales.estructuras;
import javax.swing.JOptionPane;

/**
 *
 * @author Svetlana Valentina
 */
public class Lista {
    private Nodo head;
    private Nodo tail;
    private int size;
    
    // constructor
    public Lista() {
        this.head = null;
        this.size = 0;
    }

    // getters y setters
    /**
     * @return the head
     */
    public Nodo getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Nodo head) {
        this.head = head;
    }

    /**
     * @return the tail
     */
    public Nodo getTail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(Nodo tail) {
        this.tail = tail;
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
    
    // primitivas
    public boolean isEmpty(){
        return getHead() == null;
    }
    
    public void vaciarLista(){
        head = null;
        size = 0;
    }
    
    //obtener el proximo nodo
    public Nodo nextNode(Nodo enlace){
        if(enlace.getPnext() != null){
            enlace = enlace.getPnext();
            return enlace;
        } else {
            return null;
        }
    }
    
    //imprimir
    public void printList(){
        Nodo aux = getHead();
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "la lista esta vacia");
        } else {
            String print = "";
            for (int i = 0; i < this.getSize(); i++) {
                print += " " + aux.getData().getHandle() + " " + aux.getData().getId() + "|";
                aux = nextNode(aux);
            }
            JOptionPane.showMessageDialog(null, print);
        }
    }
    
    // la informacion de los usuarios de la lista
    public String obtenerInfo(){
        Nodo aux = getHead();
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            String print = "";             
            for (int i = 0; i< this.getSize(); i++ ){
                print += aux.getData().getHandle() + ":" + " " + aux.getData().getId() +"\n";
                aux = nextNode(aux);
            }
            return print;
        }
        return null;            
    }
    
    public String ObtenerNombreDeUsuario(){
        Nodo aux = getHead();
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            String print = "";             
            for (int i = 0; i< this.getSize(); i++ ){
                print += aux.getData().getHandle() + " ; ";
                aux = nextNode(aux);            
            }
            return print;
        }
        return null;            
    }
    
    public String ObtenerId(){
        Nodo aux = getHead();
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            String print = "";             
            for (int i = 0; i< this.getSize(); i++ ){
                print += aux.getData().getId();
                aux = nextNode(aux);
            }
            return print;
        }
        return null;
    }
    
    //busca el elemento de la lista (retorna el nodo con el valor en cuestion)
    public Nodo Buscar(Object valor){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"Lista vacía");
            return null;
        } else {
            Nodo aux = getHead();
            for (int i = 0; i < this.getSize(); i++) {
                if(valor== aux.getData()){
                    return aux;
                } else {
                    aux = aux.getPnext();
                }
            }
        }
        return null;
    }
    
    //indice de la lista
    public int getIndex(Nodo node){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null, "Lista vacía");
            return -1;
        }else{
            Nodo aux = getHead();
            int cont = 0;
            while(aux != null){
                if (node == aux){
                    return cont; 
                }else{
                    aux = aux.getPnext();
                    cont ++;
                }
            } 
            return cont;
        }
    }
    
    public boolean compararUsuario(String usuario){
        Nodo temp = getHead();
        boolean encontrado = false;
        
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else{                        

            for (int i = 0; i< this.getSize(); i++ ){               
                String p = temp.getData().getHandle();
                
                if(p.equals(usuario)){
                    encontrado = true;
                    break;
                        } 
                else{
                    temp = nextNode(temp);  
                        }

               }
            
            return encontrado;
            }
        return encontrado;            
        
        }
    
    public int compararIdUsuario(int id){
        Nodo temp = getHead();
        int cont = 0;
        boolean encontrado = false;
        
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else{                        

            for (int i = 0; i< this.getSize(); i++ ){               
                int p = temp.getData().getId();
                
                if(id <= p){
                    encontrado = true;
                    break;
                        } 
                else{
                    temp = nextNode(temp);
                    cont ++;
                        } 
               }
            
            if(encontrado == true){
                return cont;
            }
            }
        return -1;            
        }
    
    // obtener nodo por indice
    public Nodo getNodo(int posicion){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null, "Lista vacía");
            return null;
        }else if(posicion >= this.size){
            JOptionPane.showMessageDialog(null,"Error");
            return null;
        }else{
            Nodo temp = getHead();
            
            for (int i = 0; i < posicion; i++) {
                temp = temp.getPnext();
            }return temp;
        }
    }
}
