package com.redes_sociales.controladores;

import com.redes_sociales.estructura.ListaEnlazada;
import com.redes_sociales.modelos.Grafo;
import com.redes_sociales.modelos.Usuario;
import com.redes_sociales.modelos.Relacion;

public class ControladorGrafo {
     private Grafo grafo;

    public ControladorGrafo(Grafo grafo) {
        this.grafo = grafo;
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
        return grafo.getRelaciones(usuario);
    }

    public int contarIslas() {
        return grafo.contarIslas();
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
                int numIslas = grafo.contarIslas();
                grafo.agregarRelacion(relacion);

                if (numIslas > grafo.contarIslas()) {
                    puentes.add(relacion);
                }
            }
        }
        
        return puentes;
    }


}
