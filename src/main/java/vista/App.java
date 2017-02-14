package vista;

import controlador.CreacionControlador;
import persistencia.GestorPersistencia;
import utils.Toast;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel jpPrincipal;
    private JToolBar jtbMenu;
    private JButton crearButton;
    private JTextPane textPane1;
    private JButton buscarButton;
    private JButton eliminarButton;
    private JButton marcasButton;
    private JButton filtrarButton;
    private JButton button2;
    private JPasswordField passwordField1;


    public App() {
        JFrame frame = new JFrame("V12 Engine");

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }

        frame.setContentPane(jpPrincipal);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creamos vista
                Crear crear = new Crear();
                // Creamos gestor (modelo)
                GestorPersistencia gestorPersistencia = new GestorPersistencia();
                // Añadimos al controlador la vista y el modelo
                CreacionControlador creacionControlador = new CreacionControlador(crear, gestorPersistencia);

                crear.setLocationRelativeTo(null);
                crear.setTitle("Crear nuevo elemento");
                crear.pack();
                crear.setVisible(true);
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modificar modificar = new Modificar();
                modificar.setLocationRelativeTo(null);
                modificar.setTitle("Modificar elemento");
                modificar.pack();
                modificar.setVisible(true);
            }
        });
    }
}
