package com.redes_sociales.modelos;

import com.redes_sociales.estructura.ListaEnlazada;
import com.redes_sociales.estructura.Nodo;

public class Grafo {
    private ListaEnlazada<UsuarioRelacion> grafo;

    public Grafo() {
        this.grafo = new ListaEnlazada<>();
    }

    public class UsuarioRelacion {
        Usuario usuario;
        ListaEnlazada<Relacion> relaciones;

        public UsuarioRelacion(Usuario usuario) {
            this.usuario = usuario;
            this.relaciones = new ListaEnlazada<>();
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public ListaEnlazada<Relacion> getRelaciones() {
            return relaciones;
        }
    }

    public void agregarUsuario(Usuario usuario) {
        this.grafo.add(new UsuarioRelacion(usuario));
    }

    public void eliminarUsuario(Usuario usuario) {
        this.grafo.remove(getUsuarioRelacion(usuario));
    }

    public void agregarRelacion(Relacion relacion) {
        Usuario usuario1 = relacion.getUsuario1();
        Usuario usuario2 = relacion.getUsuario2();
        getUsuarioRelacion(usuario1).getRelaciones().add(relacion);
        getUsuarioRelacion(usuario2).getRelaciones().add(relacion);
    }

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

    public ListaEnlazada<Relacion> getRelaciones(Usuario usuario) {
        return getUsuarioRelacion(usuario).getRelaciones();
    }

    public ListaEnlazada<Usuario> getUsuarios() {
        ListaEnlazada<Usuario> usuarios = new ListaEnlazada<>();
        for (int i = 0; i < grafo.size(); i++) {
            usuarios.add(grafo.get(i).getUsuario());
        }
        return usuarios;
    }

    public int contarIslas() {
        ListaEnlazada<Usuario> visitados = new ListaEnlazada<>();
        int numIslas = 0;

        for (int i = 0; i < grafo.size(); i++) {
            Usuario usuario = grafo.get(i).getUsuario();
            if (!visitados.contains(usuario)) {
                DFS(usuario, visitados);
                numIslas++;
            }
        }

        return numIslas;
    }

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

    public UsuarioRelacion getUsuarioRelacion(Usuario usuario) {
        for (int i = 0; i < grafo.size(); i++) {
            UsuarioRelacion usuarioRelacion = grafo.get(i);
            if (usuarioRelacion.getUsuario().equals(usuario)) {
                return usuarioRelacion;
            }
        }
        return null;
    }
    
    public ListaEnlazada<Relacion> identificarPuentes() {
    ListaEnlazada<Relacion> puentes = new ListaEnlazada<>();

    for (int i = 0; i < grafo.size(); i++) {
        UsuarioRelacion usuarioRelacion = grafo.get(i);
        ListaEnlazada<Relacion> relaciones = usuarioRelacion.getRelaciones();

        for (int j = 0; j < relaciones.size(); j++) {
            Relacion relacion = relaciones.get(j);

            // Temporalmente elimina la relacion
            eliminarRelacion(relacion.getUsuario1(), relacion.getUsuario2());

            int numIslas = contarIslas();

            // Restaura la relacion
            agregarRelacion(relacion);

            // Si el número de islas aumentó, entonces la relacion es un puente
            if (numIslas > contarIslas()) {
                puentes.add(relacion);
            }
        }
    }

    return puentes;
}

}
