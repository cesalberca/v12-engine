package vista;

import utils.Toast;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class App {
    private JFrame frame;
    private JPanel jpPrincipal;
    private JToolBar jtbMenu;
    private JButton crearButton;
    private JButton buscarButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JButton exportarButton;
    private JTable jtResultados;

    public App() {
        frame = new JFrame("V12 Engine");

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

    public void notificarExportacionCompletada() {
        Toast.makeText(frame, "Exportación completada con éxito", Toast.Style.NORMAL).display();
    }

    public void notificarErrorExportacion() {
        Toast.makeText(frame, "Error al exportar", Toast.Style.ERROR).display();
    }

    public String getRutaParaExportar() {
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".csv", "csv");
        jFileChooser.setFileFilter(filter);

        if (jFileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            return jFileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return "";
        }
    }

    public JTable getJtResultados(){
        return jtResultados;
    }

    public void notificarErrorCargaDeDatos() {
        JOptionPane.showMessageDialog(null, "Error al cargar los datos");
    }
}
