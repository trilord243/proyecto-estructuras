package com.redes_sociales;

import com.redes_sociales.controladores.ControladorArchivo;
import com.redes_sociales.controladores.ControladorGrafo;
import com.redes_sociales.vistas.VistaCargaArchivo;
import com.redes_sociales.vistas.VistaGrafo;
import com.redes_sociales.vistas.VistaIsla;
import com.redes_sociales.modelos.Grafo;
import java.io.File;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControladorArchivo controladorArchivo = new ControladorArchivo();
            VistaCargaArchivo vistaCargaArchivo = new VistaCargaArchivo(controladorArchivo);

            vistaCargaArchivo.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        String rutaArchivo = controladorArchivo.getUltimaRutaArchivo();
        if (rutaArchivo != null && !rutaArchivo.isEmpty()) {
            File archivo = new File(rutaArchivo);
            if (archivo.exists()) {
                Grafo grafo = controladorArchivo.cargarGrafoDesdeArchivo(rutaArchivo);
                ControladorGrafo controladorGrafo = new ControladorGrafo(grafo);
                VistaGrafo vistaGrafo = new VistaGrafo(controladorGrafo);
                VistaIsla vistaIsla = new VistaIsla(controladorGrafo);
                vistaGrafo.setVisible(true);
                vistaIsla.setVisible(true);
            }
        }
    }
});


            vistaCargaArchivo.setVisible(true);
        });
    }
}
