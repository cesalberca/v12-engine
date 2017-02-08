package vista;

import utils.Toast;

import javax.swing.*;

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

    public App() {
        JFrame frame = new JFrame("Gesmotor");

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }

        frame.setContentPane(jpPrincipal);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Toast.makeText(frame, "Annotations were successfully saved.", Toast.Style.SUCCESS).display();

        frame.pack();
        frame.setVisible(true);
    }
}
