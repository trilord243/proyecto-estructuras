package com.redes_sociales.vistas;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.redes_sociales.controladores.ControladorGrafo;
import com.redes_sociales.modelos.Grafo;
import com.redes_sociales.modelos.Usuario;
import com.redes_sociales.estructura.ListaEnlazada;
import com.redes_sociales.modelos.Relacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph; 

public class VistaPrincipal extends JFrame {
     private ControladorGrafo controlador;

    public VistaPrincipal(Grafo grafo) {
        controlador = new ControladorGrafo(grafo);

        setTitle("Grafo de Red Social");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JButton agregarUsuarioButton = new JButton("Agregar Usuario");
        agregarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Introduce el id del usuario");
                String nombre = JOptionPane.showInputDialog("Introduce el nombre del usuario");
                if (idString != null && !idString.isEmpty() && nombre != null && !nombre.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idString);
                        Usuario nuevoUsuario = new Usuario(id, nombre);
                        controlador.agregarUsuario(nuevoUsuario);
                        JOptionPane.showMessageDialog(null, "Usuario agregado con éxito!");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un ID válido (número entero)");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El id y el nombre del usuario no pueden estar vacíos");
                }
            }
        });
        add(agregarUsuarioButton);

        JButton agregarRelacionButton = new JButton("Agregar Relación");
        agregarRelacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUsuario1Str = JOptionPane.showInputDialog("Introduce el ID del primer usuario");
                String idUsuario2Str = JOptionPane.showInputDialog("Introduce el ID del segundo usuario");
                String tiempoAmistadStr = JOptionPane.showInputDialog("Introduce el tiempo de amistad");

                try {
                    int idUsuario1 = Integer.parseInt(idUsuario1Str);
                    int idUsuario2 = Integer.parseInt(idUsuario2Str);
                    int tiempoAmistad = Integer.parseInt(tiempoAmistadStr);

                    Usuario usuario1 = controlador.buscarUsuario(idUsuario1);
                    Usuario usuario2 = controlador.buscarUsuario(idUsuario2);

                    if (usuario1 == null || usuario2 == null) {
                        JOptionPane.showMessageDialog(null, "Uno o ambos usuarios no existen");
                    } else {
                        controlador.agregarRelacion(usuario1, usuario2, tiempoAmistad);
                        JOptionPane.showMessageDialog(null, "Relación agregada con éxito!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido para el ID del usuario y el tiempo de amistad");
                }
            }
        });
        add(agregarRelacionButton);

        JButton eliminarUsuarioButton = new JButton("Eliminar Usuario");
        eliminarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUsuarioStr = JOptionPane.showInputDialog("Introduce el ID del usuario a eliminar");

                try {
                    int idUsuario = Integer.parseInt(idUsuarioStr);
                    Usuario usuario = controlador.buscarUsuario(idUsuario);

                    if (usuario == null) {
                        JOptionPane.showMessageDialog(null, "El usuario no existe");
                    } else {
                        controlador.eliminarUsuario(usuario);
                        JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido para el ID del usuario");
                }
            }
        });
        add(eliminarUsuarioButton);

        JButton mostrarUsuariosButton = new JButton("Mostrar Usuarios");
        mostrarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaEnlazada<Usuario> usuarios = controlador.obtenerUsuarios();
                if (usuarios.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay usuarios para mostrar");
                } else {
                    StringBuilder usuariosStr = new StringBuilder();
                    for (int i = 0; i < usuarios.size(); i++) {
                        Usuario usuario = usuarios.get(i);
                        usuariosStr.append(usuario.getId()).append(" - ").append(usuario.getNombre()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, usuariosStr.toString(), "Usuarios", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        add(mostrarUsuariosButton);

        JButton contarIslasButton = new JButton("Contar Islas");
        contarIslasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numIslas = controlador.contarIslas();
                JOptionPane.showMessageDialog(null, "El número de islas en el grafo es: " + numIslas);
            }
        });
        add(contarIslasButton);

        JButton encontrarPuentesButton = new JButton("Encontrar Puentes");
        encontrarPuentesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaEnlazada<Relacion> puentes = controlador.identificarPuentes();
                StringBuilder puentesStr = new StringBuilder();
                for (int i = 0; i < puentes.size(); i++) {
                    Relacion relacion = puentes.get(i);
                    puentesStr.append(relacion.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, "Los puentes en el grafo son: \n" + puentesStr.toString());
            }
        });
        add(encontrarPuentesButton);
        
        
         JButton mostrarGrafoButton = new JButton("Mostrar Grafo");
        mostrarGrafoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarGrafo();
            }
        });
        add(mostrarGrafoButton);
    }

  private void mostrarGrafo() {
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
                int index1 = usuarios.indexOf(usuario1);
                int index2 = usuarios.indexOf(usuario2);
                if (index1 != -1 && index2 != -1) {
                    Object v1 = vertices.get(index1);
                    Object v2 = vertices.get(index2);
                    graph.insertEdge(parent, null, "", v1, v2); // Aquí se ha cambiado la etiqueta a una cadena vacía
                }
            }
        }
    } finally {
        graph.getModel().endUpdate();
    }

    mxGraphComponent graphComponent = new mxGraphComponent(graph);
    mxHierarchicalLayout layout = new mxHierarchicalLayout(graph); // Aquí se ha cambiado el layout a mxHierarchicalLayout
    layout.execute(parent);

    JFrame frame = new JFrame();
    frame.getContentPane().add(graphComponent);
    frame.setSize(1200, 800); // Aquí se ha aumentado el tamaño de la ventana
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
}








    private Object buscarVertice(ListaEnlazada<Usuario> usuarios, ListaEnlazada<Object> vertices, mxGraph graph, Object parent, Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).equals(usuario)) {
                return vertices.get(i);
            }
        }

        Object vertice = graph.insertVertex(parent, null, usuario.getNombre(), 0, 0, 80, 30);
        usuarios.add(usuario);
        vertices.add(vertice);

        return vertice;
    }

    }
    
    

