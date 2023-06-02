package com.redes_sociales.controladores;

import com.redes_sociales.estructura.Cola;
import com.redes_sociales.estructura.ListaEnlazada;
import com.redes_sociales.estructura.Nodo;
import com.redes_sociales.estructura.Pila;
import com.redes_sociales.modelos.Grafo;
import com.redes_sociales.modelos.Usuario;
import com.redes_sociales.modelos.Relacion;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Esta clase se encarga de manejar las operaciones del grafo de la red social.
 * Proporciona métodos para agregar y eliminar usuarios y relaciones, obtener usuarios y relaciones,
 * contar islas, buscar usuarios, identificar puentes, guardar cambios y realizar búsquedas en profundidad y en anchura.
 */

public class ControladorGrafo {
     private Grafo grafo;
     
     
       /**
     * Constructor de la clase ControladorGrafo.
     *
     * @param grafo el grafo que se va a manejar.
     */

    public ControladorGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
    
    /**
     * Obtiene el grafo que se está manejando.
     *
     * @return el grafo que se está manejando.
     */
    public Grafo getGrafo() {
        return this.grafo;
    }
    
        /**
     * Agrega un usuario al grafo.
     *
     * @param usuario el usuario a agregar.
     */
    public void agregarUsuario(Usuario usuario) {
        grafo.agregarUsuario(usuario);
    }
    
    
        /**
     * Elimina un usuario del grafo.
     *
     * @param usuario el usuario a eliminar.
     */

    public void eliminarUsuario(Usuario usuario) {
        grafo.eliminarUsuario(usuario);
    }
    
    
        /**
     * Agrega una relación al grafo.
     *
     * @param usuario1 el primer usuario de la relación.
     * @param usuario2 el segundo usuario de la relación.
     * @param tiempoAmistad el tiempo de amistad entre los usuarios.
     */

    public void agregarRelacion(Usuario usuario1, Usuario usuario2, int tiempoAmistad) {
        Relacion relacion = new Relacion(usuario1, usuario2, tiempoAmistad);
        grafo.agregarRelacion(relacion);
    }
    
    
        /**
     * Elimina una relación del grafo.
     *
     * @param usuario1 el primer usuario de la relación.
     * @param usuario2 el segundo usuario de la relación.
     */

    public void eliminarRelacion(Usuario usuario1, Usuario usuario2) {
        grafo.eliminarRelacion(usuario1, usuario2);
    }
    
    
    
    /**
     * Obtiene los usuarios del grafo.
     *
     * @return una lista de usuarios del grafo.
     */

    public ListaEnlazada<Usuario> obtenerUsuarios() {
        return grafo.getUsuarios();
    }
    
    
        /**
     * Obtiene las relaciones de un usuario.
     *
     * @param usuario el usuario cuyas relaciones se van a obtener.
     * @return una lista de relaciones del usuario.
     */

   public ListaEnlazada<Relacion> obtenerRelaciones(Usuario usuario) {
    Grafo.UsuarioRelacion usuarioRelacion = grafo.getUsuarioRelacion(usuario);
    if (usuarioRelacion != null) {
        return usuarioRelacion.getRelaciones();
    } else {
        return new ListaEnlazada<>(); // Devuelve una lista vacía si el usuario no tiene relaciones
    }
}



 /**
     * Cuenta el número de islas en el grafo.
     *
     * @return el número de islas en el grafo.
     */
    public int contarIslas() {
        return grafo.contarIslas(true);
    }
        /**
     * Busca un usuario en el grafo por su ID.
     *
     * @param id el ID del usuario a buscar.
     * @return el usuario si se encuentra, o null si no se encuentra.
     */

    public Usuario buscarUsuario(int id) {
        ListaEnlazada<Usuario> usuarios = grafo.getUsuarios();

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId() == id) {
                return usuario;
            }
        }

        return null;
    }
        /**
     * Identifica los puentes en el grafo.
     *
     * @return una lista de las relaciones que son puentes en el grafo.
     */
    public ListaEnlazada<Relacion> identificarPuentes() {
        ListaEnlazada<Relacion> puentes = new ListaEnlazada<>();

        ListaEnlazada<Usuario> usuarios = grafo.getUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            ListaEnlazada<Relacion> relaciones = grafo.getRelaciones(usuario);
            
            for (int j = 0; j < relaciones.size(); j++) {
                Relacion relacion = relaciones.get(j);
                grafo.eliminarRelacion(relacion.getUsuario1(), relacion.getUsuario2());
                int numIslas = grafo.contarIslas(true);
                grafo.agregarRelacion(relacion);

                if (numIslas > grafo.contarIslas(true)) {
                    puentes.add(relacion);
                }
            }
        }
        
        return puentes;
    }
        /**
     * Guarda los cambios realizados en el grafo en el archivo original.
     *
     * @param controladorArchivo el controlador de archivo que se utilizará para guardar los cambios.
     */
    
public void guardarCambios(ControladorArchivo controladorArchivo) {
    // Obtén la ruta del archivo original
    String rutaArchivo = controladorArchivo.getUltimaRutaArchivo();

    // Guarda los cambios en el archivo original
    controladorArchivo.guardarGrafoEnArchivo(this.grafo, rutaArchivo);
}
 /**
     * Realiza una búsqueda en anchura (BFS) en el grafo a partir de un usuario inicial.
     *
     * @param inicio el usuario desde el cual comenzar la búsqueda.
     * @return una lista de usuarios visitados durante la búsqueda.
     */
 public ListaEnlazada<Usuario> bfs(Usuario inicio) {
        ListaEnlazada<Usuario> visitados = new ListaEnlazada<>();
        Cola<Usuario> cola = new Cola<>();
        cola.enqueue(inicio);

        while (!cola.isEmpty()) {
            Usuario actual = cola.dequeue();
            if (!visitados.contains(actual)) {
                visitados.add(actual);
                ListaEnlazada<Relacion> relaciones = obtenerRelaciones(actual);
                for (int i = 0; i < relaciones.size(); i++) {
                    Usuario vecino = relaciones.get(i).getUsuario2();
                    cola.enqueue(vecino);
                }
            }
        }

        return visitados;
    }
 /**
     * Realiza una búsqueda en profundidad (DFS) en el grafo a partir de un usuario inicial.
     *
     * @param inicio el usuario desde el cual comenzar la búsqueda.
     * @return una lista de usuarios visitados durante la búsqueda.
     */
    public ListaEnlazada<Usuario> dfs(Usuario inicio) {
        ListaEnlazada<Usuario> visitados = new ListaEnlazada<>();
        Pila<Usuario> pila = new Pila<>();
        pila.push(inicio);

        while (!pila.isEmpty()) {
            Usuario actual = pila.pop();
            if (!visitados.contains(actual)) {
                visitados.add(actual);
                ListaEnlazada<Relacion> relaciones = obtenerRelaciones(actual);
                for (int i = 0; i < relaciones.size(); i++) {
                    Usuario vecino = relaciones.get(i).getUsuario2();
                    pila.push(vecino);
                }
            }
        }

        return visitados;
    }
}




