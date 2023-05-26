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
public class Recorridos {
    
    public static String BFS(GrafoMady grafo, String nombre){
        int valOrigin;
        Integer w = null;
        int intW;
        int[] arrVisitados = null;
        Vertice[] verts = grafo.getVerts(); // arreglo con los vertices del grafo
        String temp = "";
        
        try{
            valOrigin = grafo.buscarIndex(nombre);
            if(valOrigin < 0) throw new Exception("Verice no existe");
            Cola queue = new Cola();
            arrVisitados = new int[grafo.getNumVerts()];
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                arrVisitados[i] = -1; // los vertices se marcan con -1
            }
            arrVisitados[valOrigin] = 0; // vertice de partida se inicializa en 0
            queue.encolar(valOrigin); // se encola un nodo con el indice del vertice
            
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                if(arrVisitados[i] == -1){
                    while(!queue.esVacio()){
                        w = (Integer) queue.desencolar();
                        intW = w;
                        Vertice vert = verts[intW];
                        Lista lista = vert.getUsuarios();
                        temp += "Usuarios" + " " + vert.getNombre() + "\n" + lista.obtenerInfo() + "\n";
                        
                        //se encola los adyacentes
                        for (int j = 0; j < grafo.getNumVerts(); j++) {
                            if((w != j) && (grafo.existeArista(w, j) && arrVisitados[j] == -1)){
                            int valNodo = verts[j].getIndex();
                            queue.encolar(valNodo);
                            arrVisitados[j] = 0;
                        }
                        }
                    }
                }
            }
            return temp;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error, no se pudo recorrer el grafo en anchura");
    }
        return temp;
}
    
    public static String DFS(GrafoMady grafo, String nombre){
        int valOrigen, valSig = 0;       
        int[] arrVisitados = null;
        Vertice[] verts = grafo.getVerts();
        Pila pila = new Pila();
        arrVisitados = new int[grafo.getNumVerts()];
        String temp = "";
        
        try{
            valOrigen = grafo.buscarIndex(nombre);
            
            if (valOrigen < 0)throw new Exception("Vertice no existe");
            
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                arrVisitados[i] = -1; //Los vértices se marcan con -1            
            }
            
            arrVisitados[valOrigen] = 0; //vertice de partida se inicializa en 0
            
            pila.apilar(valOrigen);
            
            while(!pila.isEmpty()){
                Integer sig;
                sig = (Integer) pila.desapilar();
                valSig = sig;
                
                Vertice vert = verts[valSig];
                Lista lista = vert.getUsuarios();
                temp += "Usuarios" + " " + vert.getNombre() + "\n" + lista.obtenerInfo() + "\n";
                
                for (int j = 0; j < grafo.getNumVerts(); j++){
                    if((valSig != j) && (grafo.existeArista(valSig, j) && arrVisitados[j] == -1)){
                        int valNodo = verts[j].getIndex();
                        pila.apilar(valNodo); 
                        arrVisitados[j] = 0;
                    }
                }
            }
            
            return temp;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, no se pudo recorrer el grafo [Profundidad]");
            }
        
        
        
    return temp;
    }
    
    public static String busquedaUsuario(GrafoMady grafo, String nombre, Usuario usuario){
        int valOrigen;
        Integer w = null;
        int intW;
        int[] arrVisitados = null;
        Vertice[] verts = grafo.getVerts(); //arreglo con los vertices del grafo
        String vertices = "";
        boolean encontrado;
       
        
                
        try{
            valOrigen = grafo.buscarIndex(nombre);
            
           if (valOrigen < 0)throw new Exception("Vertice no existe");
        
           Cola cola = new Cola();
           arrVisitados = new int[grafo.getNumVerts()];
           
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                arrVisitados[i] = -1; //Los vértices se marcan con -1
            
            }
            
            arrVisitados[valOrigen] = 0; //vertice de partida se inicializa en 0
            cola.encolar(valOrigen); //se encola un nodo con el índice del vértice 
            
            
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                if(arrVisitados[i] == -1){
                    
                    while(!cola.esVacio()){
                        
                        
                        w = (Integer) cola.desencolar();                     
                        intW = w;
                        Vertice vert = verts[intW];
                        Lista lista = vert.getUsuarios();
                        
                    //formar el arreglo de vertices
                        encontrado = lista.compararUsuario(usuario.getHandle());  
                        
                        if (encontrado == true){
                            vertices += vert.getNombre() + ",";
                            
                        }                       
                        else{
                            
                        }
                    
                    //Se encolan los adyacentes
                    for (int j = 0; j < grafo.getNumVerts(); j++) {
                        if((w != j) && (grafo.existeArista(w, j) && arrVisitados[j] == -1)){ //Utilizar la funcion de añadir a la matriz                            
                            int valNodo = verts[j].getIndex();
                            cola.encolar(valNodo); 
                            arrVisitados[j] = 0;
                            }
                        }
                    }
                }
            
            }
            return vertices;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, no se pudo recorrer el grafo [Anchura]");
        }
        return vertices;        
   
    } 

}