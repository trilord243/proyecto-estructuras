package com.redes_sociales.modelos;

import com.redes_sociales.estructura.ListaEnlazada;

public class Isla {
    private ListaEnlazada<Usuario> usuarios;

    public Isla() {
        this.usuarios = new ListaEnlazada<>();
    }

    public ListaEnlazada<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ListaEnlazada<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    @Override
    public String toString() {
        StringBuilder strUsuarios = new StringBuilder();
        for (int i = 0; i < usuarios.size(); i++) {
            strUsuarios.append(usuarios.get(i).toString());
            if (i < usuarios.size() - 1) {
                strUsuarios.append(", ");
            }
        }
        return "Isla{" +
                "usuarios=" + strUsuarios.toString() +
                '}';
    }
}
