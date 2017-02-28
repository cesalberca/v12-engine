package vista;

import javax.swing.*;
import java.awt.*;

public class App {
    private JPanel jpPrincipal;
    private JToolBar jtbMenu;
    private JButton crearButton;
    private JButton buscarButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JButton exportarButton;
    private JTable jtResultados;

    public App() {
        JFrame frame = new JFrame("V12 Engine");

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }

        frame.setPreferredSize(new Dimension(1200, 800));

        frame.setContentPane(jpPrincipal);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton getCrearButton() {
        return this.crearButton;
    }

    public JButton getModificarButton() {
        return this.modificarButton;
    }

    public JButton getEliminarButton(){
        return this.eliminarButton;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public JButton getExportarButton() {
        return exportarButton;
    }

    public JTable getJtResultados(){
        return jtResultados;
    }
}
