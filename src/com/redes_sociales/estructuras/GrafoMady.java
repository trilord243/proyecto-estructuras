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
public class GrafoMady {
    private static int numVerts; //numero de vertices
    private int maxNodos; // size maximo de la matriz
    private static Vertice[] verts; // lista con los vertices
    private int [][] matAdy; // forma la matriz
    private String [] totalUsuarios; // todos los usuarios

    public GrafoMady(int max) {
        matAdy = new int[max][max];
        verts = new Vertice[max];
        maxNodos = max;
        numVerts = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                matAdy[i][j] = 0;
            }
            
        }
    }

    // getters y setters
    /**
     * @return the numVerts
     */
    public int getNumVerts() {
        return numVerts;
    }

    /**
     * @param aNumVerts the numVerts to set
     */
    public void setNumVerts(int aNumVerts) {
        numVerts = aNumVerts;
    }

    /**
     * @return the verts
     */
    public Vertice[] getVerts() {
        return verts;
    }

    /**
     * @param aVerts the verts to set
     */
    public void setVerts(Vertice[] aVerts) {
        verts = aVerts;
    }

    /**
     * @return the matAdy
     */
    public int[][] getMatAdy() {
        return matAdy;
    }

    /**
     * @param matAdy the matAdy to set
     */
    public void setMatAdy(int[][] matAdy) {
        this.matAdy = matAdy;
    }
    
    //metodos

    public boolean isEmpty(){
        return this.numVerts == 0;
    }
    
    //para retornar el indice de los vertices
    public static int buscarIndex(String nom){
        Vertice verti = new Vertice(nom);
        boolean existe = false;
        int i = 0;
        for (; (i < numVerts) && !existe;) {
            existe = verts[i].comparar(verti);
            if (!existe) i++;
        }
        if (existe){
            return i;
        } else {
            return -1;
        }
    }
    
    //Aristas
    public void crearArista(String u, String v, int peso){
        if(!this.isEmpty()){
            int valU, valV;
            valU = buscarIndex(u);
            valV = buscarIndex(v);
            if (valU != -1 && valV != -1){
                matAdy[valU][valV] = peso;
            } else {
                System.out.println("error el vertice no existe");
            }
        } else {
            System.out.println("error, grafo vacio");
        }
    }
    
    public void eliminarArista(String u, String v){
        if(!this.isEmpty()){
            int valU, valV;
            valU = buscarIndex(u);
            valV = buscarIndex(v);
            if(valU != -1 && valV != -1){
                matAdy[valU][valV] = 0;
            } else {
                System.out.println("Error, el vértice no existe");
            }
        } else {
            System.out.println("Error, grafo vacío");
        }
    }
    
    //comprobar si existe el arista
    public boolean existeArista(int v, int u){
        boolean existe;
        if(matAdy[v][u] != 0){
            existe = true;
        }else{
            existe = false;
        }
        return existe;
    }
    
    //vertice
    public void crearVertice(String nom){
        int existe = buscarIndex(nom);
        if(existe == -1){
            Vertice verti = new Vertice(nom);
            verti.setIndex(numVerts);
            verts[numVerts++] = verti;
        }
        
    }
    //imprimir matriz de adyacencia
    public void printMatriz(){
        System.out.printf("La matriz contiene %d vertices \n", numVerts);
        String matriz = "";
        for (int i = 0; i < maxNodos; i++) {
            matriz += ",";
            for (int j = 0; j < maxNodos; j++) {
                matriz += (matAdy[i][j]);
             
            }
        
        }
        String[] mat = matriz.split(",");
        JOptionPane.showMessageDialog(null, mat);
    }
    
    //size del grafo
    public int size(){
        int tm = 0;
        for (int i = 0; i < numVerts; i++) {
            for (int j = 0; j < numVerts; j++) {
                tm += matAdy[i][j];                
            }
            
        }
        return tm;
    }
    
    // calcula el grado de entrada del vertice
    public int gradoEnt(int j){
        int gEnt = 0;
        for (int i = 0; i < numVerts; i++) {
                gEnt += matAdy[i][j]; 
            
        }
        return gEnt;
    }
    
    // calcula el grado de salida del vertice
    public int gradoSal(int i){
        int gSal = 0;
        for (int j = 0; j < numVerts; j++) {
            gSal += matAdy[i][j];
            
        }
        return gSal;
    }
    
    public String [] UsuariosTotal()
    {
        Vertice x = new Vertice(null);
        int contador = 0;
        String temp = " ";
        for(int i = 0; i<numVerts; i++)
        {
            x = verts[i];
            Lista list = x.getUsuarios();
            contador += list.getSize();
            temp += list.ObtenerNombreDeUsuario();
        }
        totalUsuarios = new String [contador];
        String [] aux = new String [contador];
        aux = temp.split(",");
        for(int k = 1; k<aux.length-1; k++)
        {
           totalUsuarios[k]=aux[k];
        }
       return totalUsuarios;
    }
    
    public void EliminarUsuario(Usuario [] userlist, GrafoMady grafo){
    int encontrado;
    Usuario user;
    int nuevoId=0;
    Nodo temp;
    try{
        for (int i = 0; i < verts.length; i++) {
            for (int j = 0; j < userlist.length; j++) {
                encontrado = verts[i].getUsuarios().compararIdUsuario(userlist[j].getId());
                if(encontrado != -1){
                    temp = verts[i].getUsuarios().getNodo(encontrado);
                    nuevoId = Integer.parseInt(verts[i].getUsuarios().ObtenerId()) - userlist[j].getId();
                    user = new Usuario(verts[i].getUsuarios().ObtenerNombreDeUsuario(), nuevoId);
                    temp.setData(user);
                } 
            }
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No hay usuaeios registrados");
    }
}
}
