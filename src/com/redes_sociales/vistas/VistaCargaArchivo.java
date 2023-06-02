package com.redes_sociales.vistas;


import com.redes_sociales.controladores.ControladorArchivo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import com.redes_sociales.modelos.Grafo;
import com.redes_sociales.vistas.VistaPrincipal;
public class VistaCargaArchivo extends javax.swing.JFrame {
    
    private ControladorArchivo controladorArchivo;

    public VistaCargaArchivo(ControladorArchivo controladorArchivo) {
        this.controladorArchivo = controladorArchivo;

        // Configuración básica de la ventana
        this.setTitle("Carga de archivo");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Para cerrar solo esta ventana sin terminar la aplicación

        // Botón para cargar el archivo
        JButton button = new JButton("Cargar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarArchivo();
            }
        });
        this.add(button, BorderLayout.CENTER);
    }

   private void cargarArchivo() {
    JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        if (selectedFile != null) {
            Grafo grafo = controladorArchivo.cargarGrafoDesdeArchivo(selectedFile.getAbsolutePath());
            if(grafo != null) {
                controladorArchivo.setUltimaRutaArchivo(selectedFile.getAbsolutePath());
                VistaPrincipal vistaPrincipal = new VistaPrincipal(grafo, controladorArchivo);
                vistaPrincipal.setVisible(true);
                this.dispose(); // cierra la ventana de carga de archivos
            }
        }
    }
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

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
