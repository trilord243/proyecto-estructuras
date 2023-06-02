package com.redes_sociales.modelos;

import com.redes_sociales.estructura.ListaEnlazada;


/**
 * Esta clase representa una isla en un grafo de usuarios.
 * Una isla es un subgrafo conectado de usuarios.
 */
public class Isla {
    private ListaEnlazada<Usuario> usuarios;
    
    
    
      /**
     * Constructor de la clase Isla.
     */

    public Isla() {
        this.usuarios = new ListaEnlazada<>();
    }
    
    
        /**
     * Obtiene la lista de usuarios en esta isla.
     *
     * @return una lista enlazada de usuarios en esta isla.
     */


    public ListaEnlazada<Usuario> getUsuarios() {
        return usuarios;
    }
    
    
        /**
     * Establece la lista de usuarios en esta isla.
     *
     * @param usuarios la nueva lista de usuarios para esta isla.
     */

    public void setUsuarios(ListaEnlazada<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
        /**
     * Agrega un usuario a esta isla.
     *
     * @param usuario el usuario a agregar.
     */


    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
    
    
        /**
     * Elimina un usuario de esta isla.
     *
     * @param usuario el usuario a eliminar.
     */
    public void removeUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }
    
      /**
     * Devuelve una representación de cadena de esta isla, que incluye todos los usuarios en la isla.
     *
     * @return una cadena que representa esta isla.
     */
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
