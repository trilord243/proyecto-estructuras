package com.redes_sociales.modelos;

import com.redes_sociales.estructura.Cola;
import com.redes_sociales.estructura.ListaEnlazada;
import com.redes_sociales.estructura.Nodo;
/**
 * Esta clase representa un grafo, que es una estructura de datos que consiste en nodos (usuarios) y aristas (relaciones).
 * El grafo se implementa utilizando una lista enlazada de objetos UsuarioRelacion, cada uno de los cuales representa un nodo y sus aristas adyacentes.
 */
public class Grafo {
    private ListaEnlazada<UsuarioRelacion> grafo;
    
    
        /**
     * Constructor para la clase Grafo. Inicializa una lista enlazada vacía de objetos UsuarioRelacion.
     */

    public Grafo() {
        this.grafo = new ListaEnlazada<>();
    }
    
    /**
     * Esta clase interna representa un nodo en el grafo y sus aristas adyacentes.
     */

    public class UsuarioRelacion {
        Usuario usuario;
        ListaEnlazada<Relacion> relaciones;
                /**
         * Constructor para la clase UsuarioRelacion. Inicializa un nuevo nodo con el usuario dado y una lista enlazada vacía de relaciones.
         *
         * @param usuario el usuario que representa este nodo.
         */
        public UsuarioRelacion(Usuario usuario) {
            this.usuario = usuario;
            this.relaciones = new ListaEnlazada<>();
        }
        
         /**
         * Devuelve el usuario que representa este nodo.
         *
         * @return el usuario que representa este nodo.
         */

        public Usuario getUsuario() {
            return usuario;
        }
        /**
         * Devuelve las relaciones adyacentes a este nodo.
         *
         * @return las relaciones adyacentes a este nodo.
         */

        public ListaEnlazada<Relacion> getRelaciones() {
            return relaciones;
        }
    }
    
    
        /**
     * Agrega un nuevo usuario al grafo.
     *
     * @param usuario el usuario a agregar.
     */

    public void agregarUsuario(Usuario usuario) {
        this.grafo.add(new UsuarioRelacion(usuario));
    }
        /**
     * Agrega un nuevo usuario al grafo.
     *
     * @param usuario el usuario a agregar.
     */
    public void eliminarUsuario(Usuario usuario) {
        this.grafo.remove(getUsuarioRelacion(usuario));
    }
        /**
     * Agrega una nueva relación al grafo.
     *
     * @param relacion la relación a agregar.
     */
    public void agregarRelacion(Relacion relacion) {
        Usuario usuario1 = relacion.getUsuario1();
        Usuario usuario2 = relacion.getUsuario2();
        getUsuarioRelacion(usuario1).getRelaciones().add(relacion);
        getUsuarioRelacion(usuario2).getRelaciones().add(relacion);
    }
    
    
        /**
     * Elimina una relación del grafo.
     *
     * @param usuario1 el primer usuario en la relación.
     * @param usuario2 el segundo usuario en la relación.
     */


    public void eliminarRelacion(Usuario usuario1, Usuario usuario2) {
        Relacion relacion = null;
        for (int i = 0; i < getUsuarioRelacion(usuario1).getRelaciones().size(); i++) {
            Relacion r = getUsuarioRelacion(usuario1).getRelaciones().get(i);
            if ((r.getUsuario1().equals(usuario1) && r.getUsuario2().equals(usuario2)) ||
                    (r.getUsuario1().equals(usuario2) && r.getUsuario2().equals(usuario1))) {
                relacion = r;
                break;
            }
        }
        if (relacion != null) {
            getUsuarioRelacion(usuario1).getRelaciones().remove(relacion);
            getUsuarioRelacion(usuario2).getRelaciones().remove(relacion);
        }
    }
    
    
        /**
     * Obtiene las relaciones de un usuario en el grafo.
     *
     * @param usuario el usuario cuyas relaciones se van a obtener.
     * @return una lista enlazada de las relaciones del usuario.
     */

    public ListaEnlazada<Relacion> getRelaciones(Usuario usuario) {
        return getUsuarioRelacion(usuario).getRelaciones();
    }
    
    
      /**
     * Obtiene todos los usuarios en el grafo.
     *
     * @return una lista enlazada de todos los usuarios en el grafo.
     */

    public ListaEnlazada<Usuario> getUsuarios() {
        ListaEnlazada<Usuario> usuarios = new ListaEnlazada<>();
        for (int i = 0; i < grafo.size(); i++) {
            usuarios.add(grafo.get(i).getUsuario());
        }
        return usuarios;
    }

        /**
     * Cuenta el número de islas en el grafo. Una isla es un subgrafo conectado.
     *
     * @param useBfs si es true, usa la búsqueda en anchura (BFS) para contar las islas; si es false, usa la búsqueda en profundidad (DFS).
     * @return el número de islas en el grafo.
     */
   public int contarIslas(boolean useBfs) {
    int numIslas = 0;
    ListaEnlazada<Usuario> usuarios = getUsuarios();
    ListaEnlazada<Usuario> visitados = new ListaEnlazada<>();

    for (int i = 0; i < usuarios.size(); i++) {
        Usuario usuario = usuarios.get(i);
        if (!visitados.contains(usuario)) {
            ListaEnlazada<Usuario> resultado;
            if (useBfs) {
                resultado = bfs(usuario);
            } else {
                resultado = dfs(usuario);
            }
            for (int j = 0; j < resultado.size(); j++) { // Agrega los elementos uno por uno
                visitados.add(resultado.get(j));
            }
            numIslas++;
        }
    }

    return numIslas;
}



    /**
     * Realiza una búsqueda en profundidad (DFS) en el grafo a partir de un usuario dado.
     *
     * @param usuario el usuario desde donde comenzar la DFS.
     * @param visitados una lista enlazada de usuarios que ya han sido visitados.
     */


    private void DFS(Usuario usuario, ListaEnlazada<Usuario> visitados) {
        visitados.add(usuario);

        for (int i = 0; i < getUsuarioRelacion(usuario).getRelaciones().size(); i++) {
            Relacion relacion = getUsuarioRelacion(usuario).getRelaciones().get(i);
            Usuario vecino = relacion.getUsuario1().equals(usuario) ? relacion.getUsuario2() : relacion.getUsuario1();
            if (!visitados.contains(vecino)) {
                DFS(vecino, visitados);
            }
        }
    }
        /**
     * Realiza una búsqueda en anchura (BFS) en el grafo a partir de un usuario dado.
     *
     * @param inicio el usuario desde donde comenzar la BFS.
     * @return una lista enlazada de usuarios visitados durante la BFS.
     */
    
    public ListaEnlazada<Usuario> bfs(Usuario inicio) {
    ListaEnlazada<Usuario> visitados = new ListaEnlazada<>();
    Cola<Usuario> cola = new Cola<>();
    cola.enqueue(inicio);

    while (!cola.isEmpty()) {
        Usuario actual = cola.dequeue();
        if (!visitados.contains(actual)) {
            visitados.add(actual);
            ListaEnlazada<Relacion> relaciones = getRelaciones(actual);
            for (int i = 0; i < relaciones.size(); i++) {
                Usuario vecino = relaciones.get(i).getUsuario2().equals(actual) ? relaciones.get(i).getUsuario1() : relaciones.get(i).getUsuario2();
                cola.enqueue(vecino);
            }
        }
    }

    return visitados;
}

public ListaEnlazada<Usuario> dfs(Usuario inicio) {
    ListaEnlazada<Usuario> visitados = new ListaEnlazada<>();
    DFS(inicio, visitados);
    return visitados;
}

    /**
     * Obtiene el objeto UsuarioRelacion para un usuario dado.
     *
     * @param usuario el usuario cuyo objeto UsuarioRelacion se va a obtener.
     * @return el objeto UsuarioRelacion para el usuario dado, o null si el usuario no está en el grafo.
     */
    public UsuarioRelacion getUsuarioRelacion(Usuario usuario) {
        for (int i = 0; i < grafo.size(); i++) {
            UsuarioRelacion usuarioRelacion = grafo.get(i);
            if (usuarioRelacion.getUsuario().equals(usuario)) {
                return usuarioRelacion;
            }
        }
        return null;
    }
        /**
     * Identifica las relaciones en el grafo que son puentes. Un puente es una relación cuya eliminación aumentaría el número de islas en el grafo.
     *
     * @return una lista enlazada de las relaciones que son puentes.
     */
    public ListaEnlazada<Relacion> identificarPuentes() {
    ListaEnlazada<Relacion> puentes = new ListaEnlazada<>();

    for (int i = 0; i < grafo.size(); i++) {
        UsuarioRelacion usuarioRelacion = grafo.get(i);
        ListaEnlazada<Relacion> relaciones = usuarioRelacion.getRelaciones();

        for (int j = 0; j < relaciones.size(); j++) {
            Relacion relacion = relaciones.get(j);

            
            eliminarRelacion(relacion.getUsuario1(), relacion.getUsuario2());

            int numIslas = contarIslas(true);

            
            agregarRelacion(relacion);

            
            if (numIslas > contarIslas(true)) {
                puentes.add(relacion);
            }
        }
    }

    return puentes;
}

}
