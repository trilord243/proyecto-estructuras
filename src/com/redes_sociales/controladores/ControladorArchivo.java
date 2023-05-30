package com.redes_sociales.controladores;

import com.redes_sociales.modelos.Grafo;
import com.redes_sociales.modelos.Usuario;
import com.redes_sociales.modelos.Relacion;
import com.redes_sociales.estructura.ListaEnlazada;
import java.io.*;

public class ControladorArchivo {
    private static final String DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String RELATION_DELIMITER = ";";
    private String ultimaRutaArchivo;

    public String getUltimaRutaArchivo() {
        return this.ultimaRutaArchivo;
    }

    public Grafo cargarGrafoDesdeArchivo(String archivo) {
        Grafo grafo = new Grafo();
        boolean esRelaciones = false; // Variable to know if we are reading relationships
        ListaEnlazada<Usuario> listaUsuarios = new ListaEnlazada<>(); // To search users by id

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Skip header lines
                if (linea.equals("Usuarios") || linea.equals("Relaciones")) {
                    if(linea.equals("Relaciones")){
                        esRelaciones = true;
                    }
                    continue;
                }

                String[] campos = linea.split(DELIMITER);

                if(!esRelaciones){
                    // Create and add user to the graph
                    int id = Integer.parseInt(campos[0].trim());  // Trim string before parsing
                    String nombreUsuario = campos[1].trim(); // Trim string

                    Usuario usuario = new Usuario(id, nombreUsuario);
                    grafo.agregarUsuario(usuario);
                    listaUsuarios.add(usuario); // Save user in the list
                } else {
                    // Create and add relationships to the graph
                    int idUsuario1 = Integer.parseInt(campos[0].trim()); // Trim string before parsing
                    int idUsuario2 = Integer.parseInt(campos[1].trim()); // Trim string before parsing
                    int tiempoAmistad = Integer.parseInt(campos[2].trim()); // Trim string before parsing

                    Usuario usuario1 = null; // Search user1 by id
                    Usuario usuario2 = null; // Search user2 by id
                    for(int i = 0; i < listaUsuarios.size(); i++){
                        if(listaUsuarios.get(i).getId() == idUsuario1){
                            usuario1 = listaUsuarios.get(i);
                        }
                        if(listaUsuarios.get(i).getId() == idUsuario2){
                            usuario2 = listaUsuarios.get(i);
                        }
                        if(usuario1 != null && usuario2 != null){
                            break;
                        }
                    }

                    if (usuario1 != null && usuario2 != null) {
                        Relacion relacion = new Relacion(usuario1, usuario2, tiempoAmistad);
                        grafo.agregarRelacion(relacion);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return grafo;
    }

    public void guardarGrafoEnArchivo(Grafo grafo, String archivo) {
        try (FileWriter fileWriter = new FileWriter(archivo)) {
            for (int i = 0; i < grafo.getUsuarios().size(); i++) {
                Usuario usuario = grafo.getUsuarios().get(i);
                fileWriter.append(String.valueOf(usuario.getId()));
                fileWriter.append(DELIMITER);
                fileWriter.append(usuario.getNombre());

                for (int j = 0; j < grafo.getRelaciones(usuario).size(); j++) {
                    Relacion relacion = grafo.getRelaciones(usuario).get(j);
                    fileWriter.append(DELIMITER);
                    fileWriter.append(String.valueOf(relacion.getUsuario2().getId()));
                    fileWriter.append(RELATION_DELIMITER);
                    fileWriter.append(String.valueOf(relacion.getTiempoAmistad()));
                }

                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
