package com.redes_sociales.modelos;


/**
 * Esta clase representa una relación entre dos usuarios en un grafo de redes sociales.
 * Cada relación tiene un tiempo de amistad asociado que representa la duración de la relación.
 */

public class Relacion {
    private Usuario usuario1;
    private Usuario usuario2;
    private int tiempoAmistad;
    
    
       /**
     * Contructor que crea una nueva relación entre dos usuarios con un tiempo de amistad específico.
     *
     * @param usuario1 el primer usuario en la relación.
     * @param usuario2 el segundo usuario en la relación.
     * @param tiempoAmistad la duración de la relación en algún tiempo unitario.
     */

    public Relacion(Usuario usuario1, Usuario usuario2, int tiempoAmistad) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.tiempoAmistad = tiempoAmistad;
    }
        /**
     * Obtiene el primer usuario en esta relación.
     *
     * @return el primer usuario.
     */
    public Usuario getUsuario1() {
        return usuario1;
    }
    
      /**
     * Establece el primer usuario en esta relación.
     *
     * @param usuario1 el nuevo primer usuario.
     */

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }
    
    
        /**
     * Obtiene el segundo usuario en esta relación.
     *
     * @return el segundo usuario.
     */


    public Usuario getUsuario2() {
        return usuario2;
    }
    
        /**
     * Establece el segundo usuario en esta relación.
     *
     * @param usuario2 el nuevo segundo usuario.
     */

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }
   /**
     * Obtiene el tiempo de amistad de esta relación.
     *
     * @return el tiempo de amistad.
     */
    public int getTiempoAmistad() {
        return tiempoAmistad;
    }
    
        /**
     * Establece el tiempo de amistad de esta relación.
     *
     * @param tiempoAmistad el nuevo tiempo de amistad.
     */

    public void setTiempoAmistad(int tiempoAmistad) {
        this.tiempoAmistad = tiempoAmistad;
    }
    
    
       /**
     * Devuelve una representación de cadena de esta relación, que incluye ambos usuarios y el tiempo de amistad.
     *
     * @return una cadena que representa esta relación.
     */
    @Override
    public String toString() {
        return "Relacion{" +
                "usuario1=" + usuario1 +
                ", usuario2=" + usuario2 +
                ", tiempoAmistad=" + tiempoAmistad +
                '}';
    }
}
