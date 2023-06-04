package com.redes_sociales.vistas;


import com.redes_sociales.controladores.ControladorArchivo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import com.redes_sociales.modelos.Grafo;
import com.redes_sociales.vistas.VistaPrincipal;
import javax.swing.border.Border;


/**
 * Esta clase representa la vista de carga de archivos en la aplicación de redes sociales.
 * Permite al usuario seleccionar y cargar un archivo de texto que contiene los datos del grafo de la red social.
 */

public class VistaCargaArchivo extends javax.swing.JFrame {
    
    private ControladorArchivo controladorArchivo;
    
    
    /**
     * Crea una nueva vista de carga de archivos con un controlador de archivos específico.
     *
     * @param controladorArchivo el controlador de archivos que se utilizará para cargar los datos del grafo.
     */

     public VistaCargaArchivo(ControladorArchivo controladorArchivo) {
        this.controladorArchivo = controladorArchivo;
        
         class RoundedBorder implements Border {
    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }
}

          this.setTitle("Carga de archivo");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#D3DCF2")); 

        // Panel de bienvenida
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setBackground(Color.decode("#D3DCF2")); // Cambia el color de fondo del panel
        JLabel welcomeLabel = new JLabel("Bienvenido a la aplicación de red social");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Aumenta el tamaño de la fuente
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel instructionLabel = new JLabel("Carga tu archivo txt para ver las siguientes opciones:");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Añade espacio antes del mensaje de bienvenida
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Añade espacio entre el mensaje de bienvenida y la instrucción
        welcomePanel.add(instructionLabel);
        this.add(welcomePanel, BorderLayout.NORTH);

        // Botón para cargar el archivo
        JButton button = new JButton("Cargar");
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(Color.decode("#7690CF"));
        button.setForeground(Color.decode("#43464C"));
        button.setPreferredSize(new Dimension(150, 50));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarArchivo();
            }
        });
        button.setBorder(new RoundedBorder(30)); 
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        // Panel para el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.decode("#D3DCF2")); // Cambia el color de fondo del panel
        buttonPanel.add(button);
        this.add(buttonPanel, BorderLayout.CENTER);
    }
     
         /**
     * Abre un diálogo de selección de archivos y carga el archivo seleccionado en el grafo de la red social.
     */
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
