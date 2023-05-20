package com.redes_sociales.controladores;

import com.redes_sociales.modelos.Grafo;
import com.redes_sociales.modelos.Usuario;
import com.redes_sociales.modelos.Relacion;

import java.util.List;
import java.util.Set;

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
        grafo.removeRelacion(usuario1, usuario2);
    }

    public Set<Usuario> obtenerUsuarios() {
        return grafo.getUsuarios();
    }

    public List<Relacion> obtenerRelaciones(Usuario usuario) {
        return grafo.getRelaciones(usuario);
    }

    public int contarIslas() {
        return grafo.contarIslas();
    }

    public List<Relacion> identificarPuentes() {
        return grafo.identificarPuentes();
    }
    public Usuario buscarUsuario(int id) {
        Set<Usuario> usuarios = grafo.getUsuarios();

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }

        return null;
    }
    
}
