
package com.redes_sociales.vistas;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.redes_sociales.controladores.ControladorGrafo;
import com.redes_sociales.estructura.ListaEnlazada;
import com.redes_sociales.modelos.Relacion;
import com.redes_sociales.modelos.Usuario;
import javax.swing.JFrame;


/**
 * Esta clase representa una vista de un grafo de red social utilizando la biblioteca mxGraph.
 * Proporciona una interfaz de usuario para visualizar el grafo de la red social.
 */


public class mxGraphtComponent extends javax.swing.JFrame {
 ControladorGrafo controlador;
 
 
 
     /**
     * Crea una nueva vista de grafo con un controlador de grafo específico.
     *
     * @param controlador el controlador de grafo que se utilizará para interactuar con el grafo.
     */

    public mxGraphtComponent(ControladorGrafo controlador) {
        this.controlador = controlador;
        initComponents();

        setTitle("Grafo de Red Social");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();

        try {
            ListaEnlazada<Usuario> usuarios = controlador.obtenerUsuarios();
            ListaEnlazada<Object> vertices = new ListaEnlazada<>();

            for (int i = 0; i < usuarios.size(); i++) {
                Usuario usuario = usuarios.get(i);
                Object vertice = graph.insertVertex(parent, null, usuario.getNombre(), 0, 0, 80, 30);
                vertices.add(vertice);
            }

            for (int i = 0; i < usuarios.size(); i++) {
                Usuario usuario = usuarios.get(i);
                ListaEnlazada<Relacion> relaciones = controlador.obtenerRelaciones(usuario);

                for (int j = 0; j < relaciones.size(); j++) {
                    Relacion relacion = relaciones.get(j);
                    Usuario usuario1 = relacion.getUsuario1();
                    Usuario usuario2 = relacion.getUsuario2();

                    int indexUsuario1 = usuarios.indexOf(usuario1);
                    int indexUsuario2 = usuarios.indexOf(usuario2);

                    Object v1 = vertices.get(indexUsuario1);
                    Object v2 = vertices.get(indexUsuario2);

                    graph.insertEdge(parent, null, "Amigos por " + relacion.getTiempoAmistad() + " años", v1, v2);
                }
            }
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
