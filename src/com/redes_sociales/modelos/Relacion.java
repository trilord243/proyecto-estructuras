package com.redes_sociales.modelos;

public class Relacion {
    private Usuario usuario1;
    private Usuario usuario2;
    private int tiempoAmistad;

    public Relacion(Usuario usuario1, Usuario usuario2, int tiempoAmistad) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.tiempoAmistad = tiempoAmistad;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public int getTiempoAmistad() {
        return tiempoAmistad;
    }

    public void setTiempoAmistad(int tiempoAmistad) {
        this.tiempoAmistad = tiempoAmistad;
    }

    @Override
    public String toString() {
        return "Relacion{" +
                "usuario1=" + usuario1 +
                ", usuario2=" + usuario2 +
                ", tiempoAmistad=" + tiempoAmistad +
                '}';
    }
}
