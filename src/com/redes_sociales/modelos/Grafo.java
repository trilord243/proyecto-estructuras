package com.redes_sociales.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {
    private Map<Usuario, List<Relacion>> grafo;

    public Grafo() {
        this.grafo = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        this.grafo.putIfAbsent(usuario, new ArrayList<>());
    }
      public void removeRelacion(Usuario usuario1, Usuario usuario2) {
        Relacion relacion = null;
        for (Relacion r : grafo.get(usuario1)) {
            if ((r.getUsuario1().equals(usuario1) && r.getUsuario2().equals(usuario2)) || 
                (r.getUsuario1().equals(usuario2) && r.getUsuario2().equals(usuario1))) {
                relacion = r;
                break;
            }
        }
        if (relacion != null) {
            grafo.get(usuario1).remove(relacion);
            grafo.get(usuario2).remove(relacion);
        }
    }

    public void eliminarUsuario(Usuario usuario) {
        this.grafo.remove(usuario);
        for (List<Relacion> relaciones : this.grafo.values()) {
            relaciones.removeIf(relacion -> relacion.getUsuario1().equals(usuario) || relacion.getUsuario2().equals(usuario));
        }
    }

    public void agregarRelacion(Relacion relacion) {
        Usuario usuario1 = relacion.getUsuario1();
        Usuario usuario2 = relacion.getUsuario2();
        grafo.putIfAbsent(usuario1, new ArrayList<>());
        grafo.putIfAbsent(usuario2, new ArrayList<>());
        grafo.get(usuario1).add(relacion);
        grafo.get(usuario2).add(relacion);
    }

    private void DFS(Usuario usuario, Set<Usuario> visitados) {
        visitados.add(usuario);

        for (Relacion relacion : grafo.get(usuario)) {
            Usuario vecino = relacion.getUsuario1().equals(usuario) ? relacion.getUsuario2() : relacion.getUsuario1();
            if (!visitados.contains(vecino)) {
                DFS(vecino, visitados);
            }
        }
    }
      public Set<Usuario> getUsuarios() {
        return this.grafo.keySet();
    }
    public int contarIslas() {
        Set<Usuario> visitados = new HashSet<>();
        int numIslas = 0;

        for (Usuario usuario : grafo.keySet()) {
            if (!visitados.contains(usuario)) {
                DFS(usuario, visitados);
                numIslas++;
            }
        }

        return numIslas;
    }
        public List<Relacion> getRelaciones(Usuario usuario) {
        return this.grafo.get(usuario);
    }
    private void DFS(Usuario usuario, Map<Usuario, Integer> visitados, Map<Usuario, Integer> low, List<Relacion> puentes, Usuario padre, int tiempo) {
        visitados.put(usuario, tiempo);
        low.put(usuario, tiempo);
        tiempo++;

        for (Relacion relacion : grafo.get(usuario)) {
            Usuario vecino = relacion.getUsuario1().equals(usuario) ? relacion.getUsuario2() : relacion.getUsuario1();
            if (vecino.equals(padre)) {
                continue;
            }

            if (!visitados.containsKey(vecino)) {
                DFS(vecino, visitados, low, puentes, usuario, tiempo);
                low.put(usuario, Math.min(low.get(usuario), low.get(vecino)));

                if (visitados.get(usuario) < low.get(vecino)) {
                    puentes.add(relacion);
                }
            } else {
                low.put(usuario, Math.min(low.get(usuario), visitados.get(vecino)));
            }
        }
    }

    public List<Relacion> identificarPuentes() {
        Map<Usuario, Integer> visitados = new HashMap<>();
        Map<Usuario, Integer> low = new HashMap<>();
        List<Relacion> puentes = new ArrayList<>();
        int tiempo = 0;

        for (Usuario usuario : grafo.keySet()) {
            if (!visitados.containsKey(usuario)) {
                DFS(usuario, visitados, low, puentes, null, tiempo);
            }
        }

        return puentes;
    }
}
