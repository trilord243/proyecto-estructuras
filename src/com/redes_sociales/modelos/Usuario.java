package com.redes_sociales.modelos;


/**
 * Esta clase representa a un usuario en un grafo de redes sociales.
 * Cada usuario tiene un identificador único y un nombre.
 */

public class Usuario {
    private int id;
    private String nombre;
    
     /**
     * constructor que Crea un nuevo usuario con un identificador y un nombre específicos.
     *
     * @param id el identificador único del usuario.
     * @param nombre el nombre del usuario.
     */

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
        /**
     * Obtiene el identificador de este usuario.
     *
     * @return el identificador del usuario.
     */
    public int getId() {
        return id;
    }
    
    
       /**
     * Establece el identificador de este usuario.
     *
     * @param id el nuevo identificador del usuario.
     */

    public void setId(int id) {
        this.id = id;
    }
    
    
        /**
     * Obtiene el nombre de este usuario.
     *
     * @return el nombre del usuario.
     */

    public String getNombre() {
        return nombre;
    }
    
    
        /**
     * Establece el nombre de este usuario.
     *
     * @param nombre el nuevo nombre del usuario.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
        /**
     * Devuelve una representación de cadena de este usuario, que incluye el identificador y el nombre.
     *
     * @return una cadena que representa a este usuario.
     */

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
