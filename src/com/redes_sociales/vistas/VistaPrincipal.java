package com.redes_sociales.vistas;

import com.redes_sociales.controladores.ControladorGrafo;
import com.redes_sociales.modelos.Grafo;
import com.redes_sociales.modelos.Usuario;
import java.util.Set;
import java.util.List;
import com.redes_sociales.modelos.Relacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;



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
        Set<Usuario> usuarios = controlador.obtenerUsuarios();
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios para mostrar");
        } else {
            StringBuilder usuariosStr = new StringBuilder();
            for (Usuario usuario : usuarios) {
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
        List<Relacion> puentes = controlador.identificarPuentes();
        String puentesStr = puentes.stream()
                                   .map(Relacion::toString)
                                   .collect(Collectors.joining("\n"));
        JOptionPane.showMessageDialog(null, "Los puentes en el grafo son: \n" + puentesStr);
    }
});
add(encontrarPuentesButton);

    }
}
