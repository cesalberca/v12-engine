package vista;

import controlador.CrearControlador;
import persistencia.GestorPersistencia;

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
    }

    public JButton getCrearButton() {
        return this.crearButton;
    }

    public JButton getModificarButton() {
        return this.buscarButton;
    }
}
