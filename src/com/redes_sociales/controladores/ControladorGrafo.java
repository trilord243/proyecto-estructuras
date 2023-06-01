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

public class ControladorGrafo {
     private Grafo grafo;

    public ControladorGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    public Grafo getGrafo() {
        return this.grafo;
    }
    public void agregarUsuario(Usuario usuario) {
        grafo.agregarUsuario(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        grafo.eliminarUsuario(usuario);
    }

    public void agregarRelacion(Usuario usuario1, Usuario usuario2, int tiempoAmistad) {
        Relacion relacion = new Relacion(usuario1, usuario2, tiempoAmistad);
        grafo.agregarRelacion(relacion);
    }

    public void eliminarRelacion(Usuario usuario1, Usuario usuario2) {
        grafo.eliminarRelacion(usuario1, usuario2);
    }

    public ListaEnlazada<Usuario> obtenerUsuarios() {
        return grafo.getUsuarios();
    }

   public ListaEnlazada<Relacion> obtenerRelaciones(Usuario usuario) {
    Grafo.UsuarioRelacion usuarioRelacion = grafo.getUsuarioRelacion(usuario);
    if (usuarioRelacion != null) {
        return usuarioRelacion.getRelaciones();
    } else {
        return new ListaEnlazada<>(); // Devuelve una lista vacía si el usuario no tiene relaciones
    }
}




    public int contarIslas() {
        return grafo.contarIslas(true);
    }

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
    
    
public void guardarCambios(ControladorArchivo controladorArchivo) {
    // Obtén la ruta del archivo original
    String rutaArchivo = controladorArchivo.getUltimaRutaArchivo();

    // Guarda los cambios en el archivo original
    controladorArchivo.guardarGrafoEnArchivo(this.grafo, rutaArchivo);
}

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




