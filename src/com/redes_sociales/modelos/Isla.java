package com.redes_sociales.modelos;

import java.util.ArrayList;
import java.util.List;

public class Isla {
    private List<Usuario> usuarios;

    public Isla() {
        this.usuarios = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
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
        return "Isla{" +
                "usuarios=" + usuarios +
                '}';
    }
}
