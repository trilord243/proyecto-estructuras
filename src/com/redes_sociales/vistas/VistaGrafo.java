
package com.redes_sociales.vistas;

import com.redes_sociales.controladores.ControladorGrafo;
import com.redes_sociales.modelos.Usuario;
import com.redes_sociales.modelos.Relacion;

import javax.swing.*;
import java.awt.*;
import java.util.Set;
import java.util.List;

public class VistaGrafo extends javax.swing.JFrame {
    
    
 private ControladorGrafo controladorGrafo;
    private JTextArea textArea;

    public VistaGrafo(ControladorGrafo controladorGrafo) {
        this.controladorGrafo = controladorGrafo;

        // Configuración básica de la ventana
        this.setTitle("Vista Grafo");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una textArea para mostrar la información del grafo
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Agregar un JScrollPane para permitir el desplazamiento cuando hay muchos datos
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);

        initComponents();
    }

    public void mostrarUsuarios() {
        Set<Usuario> usuarios = controladorGrafo.obtenerUsuarios();
        textArea.append("Usuarios en el grafo:\n");
        for (Usuario usuario : usuarios) {
            textArea.append(usuario.getId() + ", " + usuario.getNombre() + "\n");
        }
    }

    public void mostrarPuentes() {
        List<Relacion> puentes = controladorGrafo.identificarPuentes();
        textArea.append("Puentes en el grafo:\n");
        for (Relacion relacion : puentes) {
            textArea.append(relacion.getUsuario1().getNombre() + " - " + relacion.getUsuario2().getNombre() + "\n");
        }
    }
                          

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
